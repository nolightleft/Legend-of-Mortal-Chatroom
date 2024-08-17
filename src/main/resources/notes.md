# Thymeleaf + AJAX
- Put all fragments you want to update inside a single file, create a div to contain them
    - `<div th:fragment="parent-fragment"> `
    -   // child fragments
    - `</div>`
- In the controller, put everything the templates need in the `pModel`, then return the parent fragment
    - `return "path/to/file :: parent-fragment";`
- Give the fragment the same id as fragment name
    - <div id = "fragment1" th:fragment="fragment1"> </div>
- Call the fragment with a single empty dev:
    - <div th:replace="~{path/to/file :: fragment-name} />
- In the Js function where elements are updated, call `updateFragment` function for each child fragment

# My JS Rules
- onload / oninput methods are best added to html so you know what will be called when viewing html with developer tools
- onload / oninput methods defined in js file should start with 'o', like oSearch
- onload / oninput methods when called in html, should start with 'javascript:' so one text search could show all called methods
