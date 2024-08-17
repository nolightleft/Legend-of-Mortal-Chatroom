console.log("chat-room.js loaded");

function oSwitchProfileVisibility(profileId) {
    const profileClassList = document.getElementById(profileId).classList;
    const tokenHidden = 'hidden'
    
    if (profileClassList.contains(tokenHidden)) {
        console.log("showing profile...");
        profileClassList.remove(tokenHidden);
    } else {
        console.log("hiding profile...");
        profileClassList.add(tokenHidden);
    }
}

document.addEventListener('click', (event) => {
    const currentIcon = document.getElementById('current-icon');
    const currentProfile = document.getElementById('current-profile');
    
    if (!currentProfile.contains(event.target) && !currentIcon.contains(event.target)) {
        currentProfile.classList.add('hidden');
    }
    
    const opponentIcon = document.getElementById('opponent-icon');
    const opponentProfile = document.getElementById('opponent-profile');
    
    if (!opponentProfile.contains(event.target) && !opponentIcon.contains(event.target)) {
        opponentProfile.classList.add('hidden');
    }
});

document.getElementById('message-content').addEventListener('keydown', (event) => {
      if (event.key === 'Enter') {
         oSendMessage('save-message');
      }
});

function oSearch(inputElement) {
    const listItems = document.querySelectorAll('ul.chat-list');
    
    const searchTerm = inputElement.value.toLowerCase();

    listItems.forEach(item => {
        console.log(item); 
        
        const nameDiv = item.querySelector('div.name');
        const nameText = nameDiv.textContent.toLowerCase();

        if (searchTerm === '' || nameText.includes(searchTerm)) {
            item.classList.remove('hidden');
        } else {
            item.classList.add('hidden');
        }
      });
}

function oSendMessage(endpoint) {
    const friendId = document.getElementById("chat-header").dataset.friendId;
    const messageContent = document.getElementById("message-content").value;
    const isUseAi = document.getElementById("ai-checkbox").checked;
    
    console.log(isUseAi);
    
    if (messageContent === '' || !messageContent) {
        return;
    }
    
    document.getElementById("message-content").value = null;
    
    fetch(endpoint, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            friendId: friendId
            , messageContent: messageContent
            , isUseAi: isUseAi
        })
    })
        .then(response => response.text())
        .then(chatHistoryFragment => {
            updateFragment("chat-history", chatHistoryFragment);
            oScrollChatHistoryToBottom();
        })
}

function oScrollChatHistoryToBottom() {
    const element = document.querySelector("#chat-history");
    element.scrollTop = element.scrollHeight;
}

function updateFragment(fragmentId, parentFragmentText) {
    const fragmentDoc = new DOMParser().parseFromString(parentFragmentText, 'text/html');
    
    const sourceElement = document.getElementById(fragmentId);
    const replaceElement = fragmentDoc.getElementById(fragmentId);
    sourceElement.innerHTML = replaceElement.innerHTML;
    
    for (let i = 0; i < replaceElement.attributes.length; i++) {
        const attribute = replaceElement.attributes.item(i);
        sourceElement.setAttribute(attribute.name, attribute.value);
    }
}

function oHandleFriendClick(element) {
    const friendId = element.dataset.friendId;

    fetch('/update-chat', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            friendId: friendId
        })
    })
        .then(response => response.text())
        .then(combinedFragment => {
            // console.log(combinedFragment);

            updateFragment("chat-history", combinedFragment);
            updateFragment("chat-header", combinedFragment);
            updateFragment("profiles", combinedFragment);
            
            oScrollChatHistoryToBottom();
        })
        .catch(error => {
            console.error('Error updating chat:', error);
        });
}

function handleActiveItem(listItem) {
    const listItems = document.querySelectorAll('ul li.clearfix');
    listItems.forEach(item => item.classList.remove('active'));

    listItem.classList.add('active');
}