package com.nolightleft.chatroom;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.nolightleft.chatroom.entity.Message;
import com.nolightleft.chatroom.entity.User;
import com.nolightleft.chatroom.repository.MessageRepository;
import com.nolightleft.chatroom.repository.UserRepository;

@SpringBootApplication
public class ChatroomApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatroomApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(UserRepository pUserRepository, MessageRepository pMessageRepository) {
		return args -> {
			if (!pUserRepository.findAll().isEmpty()) {
				return;
			}
			
			pUserRepository.saveAll(Arrays.asList(
					new User(1L, "趙活", "", 16, true, LocalDate.of(1200, 6, 15), "zhaohuo.png",
							"词条-勇者:平凡如你縱使跌跌撞撞,依然勇於挑戰人生。沒有任何特殊能力,這才叫勇者。"),
					User.newHuoxiaFCharacter(2L, "虞小梅", 16, "yuxiaomei.png", 
							"據說,小梅生母是極樂教妖女。\n"
							+ "其母脫離魔爪以後,嫁人生女,安貧樂\n"
							+ "道,無奈好景不常,火龍仙君美其名日\n"
							+ "數惡除奸,狠心拆散天倫,強收虞氏孤\n"
							+ "女為門下弟子,改名小梅,著意培養,\n"
							+ "欲圖第一掌派夫人之位,以此穩固的權\n"
							+ "勢。\n"
							+ "是以小梅看似天真爛漫,其實對崆峒派\n"
							+ "揣懷著仇恨,總是笑吟吟的穿針引線,\n"
							+ "將種種事情往惡劣的局勢誘導,作為報\n"
							+ "復。\n"
							+ "甚至私下將本門秘笈《仙鶴迷蹤拳》傳\n"
							+ "授給火閃電,強迫鳥學武功,都不顧火閃電的感受，簡直不可理喻。"),
					User.newHuoxiaFCharacter(3L, "夏侯蘭", 20, "xiahoulan.png", 
							"事到如今已經無法把視線從你身上挪開了,看著你變得強大、變得堅強的模樣,比自己有所成就還令她驕傲。想看你變得更有出息,從旁見證你能走到多遠,就算沒了師徒名份,還能以你的友人自居,或是按你所想,將自己當獎勵嫁你作妻子亦無妨。青出於藍,更勝於藍,夏侯蘭逢人就想炫耀自己是你師父,亦是你心上之人。你是她戀棧人間的理由。"),
					User.newHuoxiaFCharacter(4L, "龍湘", 16, "longxiang.png", 
							"放眼江湖,挨她毒打最多次的人,莫過\n"
							+ "於你了。\n"
							+ "怎麼打都鍥而不捨,反是她越打越不捨\n"
							+ "得。\n"
							+ "她厭倦了空有皮相,錦衣華服,賣奏靈\n"
							+ "灑風流的武林少俠,偏愛你的骨氣。\n"
							+ "『我的心上人,是天下第一的大英雄,\n"
							+ "大豪傑,鐵骨錚錚,頂天立地。』就像\n"
							+ "父親一樣,如是說道,龍湘事後臉紅了\n"
							+ "三天,見了你就會立刻拔劍相向。\n"
							+ "但是離不開你的照顧,最終都只能強抑\n"
							+ "著羞恥心回到你身邊。\n"
							+ "偶爾也想振作起來,幹些為人妻子的本\n"
							+ "份,因此在縫補衣物時撕爛了你的衣衫\n"
							+ "、在煮菜時燒了房子。\n"
							+ "你最好別對這人心懷期待。"),
					User.newHuoxiaFCharacter(5L, "上官瑩", 16, "shangguanying.png", 
							"師從嵩山派福建分院,自小便受佛法薰陶,也學些拳腳功夫防身,武功不算高明,唯獨天賦異稟,是個能將苦惱拳發揮到突破十二成功力的奇女子,你最好招子放亮點,別太惹人生氣。自小便與南宮世家大公子有婚姻之約,盡管盡心經營這段關係,但相處始終不大融洽。"),
					User.newHuoxiaFCharacter(6L, "魏菊", 0, "weiju.png", 
							"先掌派人臨終之前,特地從耕陽讀書齋招來的遠親,易舊名為菊,襲任玄功掌門,兼作嫡傳女弟子。莫看她柔若無骨,總是笑容可掬的樣子,實則御下有方,現為崆峒派司書,上掌高深典籍,下掌一切戶籍、六畜、收支用度,崆峒派有她,一切才井井有條。"),
					User.newHuoxiaFCharacter(7L, "唐默鈴", 14, "tangmoling.png", 
							"唐門裡姓唐的全是家人,只有你不姓唐\n"
							+ ",偏生又那麼熟稔,不知該怎麼歸類。\n"
							+ "默鈴變得非常的關注你。\n"
							+ "無時不刻想要靠近你,安靜地在你附近\n"
							+ "待著。\n"
							+ "她純真的眼裡見不到皮相的美醜,只是\n"
							+ "單純地貪戀著安心的感覺。\n"
							+ "對江湖事不太上心,連下山的路都認不\n"
							+ "清,卻十分清楚自己傾慕著你。\n"
							+ "面無表情的少女像花一樣綻放著,與你\n"
							+ "相偕的平凡歲月,每一天都無與倫比。")
					, User.newHuoxiaFCharacter(8L, "葉雲裳", 14, "yeyunshang.png", 
							"生來體弱,經常發燒臥病在床,\n"
							+ "幸而生性達觀,不以為意。\n"
							+ "愛撒嬌,點蒼上下無不溺愛於她,\n"
							+ "可謂呼風喚雨。\n"
							+ "雖然在兄長督促下習練點蒼武功心法,\n"
							+ "但限於體質,縱使記得滾瓜爛熟,亦難\n"
							+ "有進境,連走得稍微快些都會喘,更遑\n"
							+ "論舞刀弄劍。\n"
							+ "沒有特別的愛好,但是對於山下的世界/\n"
							+ "充滿好奇。\n"
							+ "討厭吃苦,討厭吃藥,硬是強餵就會吐\n"
							+ ",\n"
							+ "\n"
							+ "吐完還會一副幸災樂禍的嘴臉嘲諷人。")
					, User.newHuoxiaFCharacter(9L, "郁竹", 16, "yuzhu.png", 
							"由於眼力不好,經常瞇著眼睛瞧人,產\n"
							+ "生了無論對誰都目露凶光的惡劣印象,\n"
							+ "其實是位性情純良的姑娘。\n"
							+ "身為鐵拳門當代嫡傳女弟子,有權角逐\n"
							+ "將來掌派夫人之位的人選,按理應該備\n"
							+ "受尊崇,但實際上誰也不將這臭臉矮冬\n"
							+ "瓜當作一回事,鐵拳門似乎也已經放棄\n"
							+ "掙扎了,由著她窩居在大鐵鋪中敲敲打\n"
							+ "打,渾不似個大家閨秀。\n"
							+ "手頭愛用的鐵槌雖是凡物,但一雙貌不\n"
							+ "驚人的手套卻是價值連城的寶物,乃由\n"
							+ "天山「烏蠶絲」織就,水火不侵,刀槍\n"
							+ "不入。")
					));

			List<User> users = pUserRepository.findAll();

			User zhaoHuo = users.get(0);
			pMessageRepository.saveAll(new ArrayList<>(Arrays.asList(
					new Message(users.get(2), zhaoHuo, "那不然為師有可能隻身一人,跋涉千里,只為了尋你而來嗎?"),
					new Message(zhaoHuo, users.get(2),
							"那倒是不可能。就是我親生爹娘,也是趕我出門以後,就此不復再見。天下壓根沒一人記掛著我,我若消失了,誰也不會放心上。"),
					new Message(users.get(2), zhaoHuo, "我會。"),
					new Message(zhaoHuo, users.get(2), "♪還是師傅你疼我。"),
					new Message(users.get(1), zhaoHuo, "不要去了,快逃吧,阿活。\r\n" + "逃得越遠越好,遠離唐門 …… 不,遠離中原最好。"),
					new Message(zhaoHuo, users.get(1), "這是什麼話？"),
					new Message(users.get(1), zhaoHuo, "我不是和你說笑的。"),
					new Message(users.get(3), zhaoHuo, "沒有。說來汗顏,我、我意識到自己似乎是俗稱的廢人。\r\n" + "不用劍的話,竟然啥也不會,一無是處。"),
					new Message(zhaoHuo, users.get(3),
							"這種事,不是很正常嗎?\r\n" + "工欲善其事,必先利其器,巧婦也難為無米炊。\r\n" + "哪怕是皇宮御廚,不給鍋子不給鏟,他也整不出什麼花樣來啊。"),
					new Message(users.get(3), zhaoHuo, "你也太好心了,連我師父都沒這樣慣著我。"),
					new Message(users.get(4), zhaoHuo, "趙活。"),
					new Message(users.get(5), zhaoHuo, "趙師兄。"),
					new Message(users.get(6), zhaoHuo, "好像是這樣······。"),
					new Message(zhaoHuo, users.get(6), "是怎樣？"),
					new Message(users.get(6), zhaoHuo, "······是我害怕見不到你。")
					, new Message(users.get(7), zhaoHuo, "♪趙哥哥。")
					, new Message(users.get(8), zhaoHuo, "趙活。")
					)));
		};
	}

}
