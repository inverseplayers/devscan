package app

import io.circe.parser.decode
import io.circe.{Json, JsonObject}

object JsonData:
  val ex = raw"""{"a": ["안","녕"]}"""

  val resume =
    raw"""Section 1.10.33 of \"de Finibus Bonorum et Malorum\", written by Cicero in 45 BC\n\"At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.\"\n\n1914 translation by H. Rackham\n\"On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire, that they cannot foresee the pain and trouble that are bound to ensue; and equal blame belongs to those who fail in their duty through weakness of will, which is the same as saying through shrinking from toil and pain. These cases are perfectly simple and easy to distinguish. In a free hour, when our power of choice is untrammelled and when nothing prevents our being able to do what we like best, every pleasure is to be welcomed and every pain avoided. But in certain circumstances and owing to the claims of duty or the obligations of business it will frequently occur that pleasures have to be repudiated and annoyances accepted. The wise man therefore always holds in these matters to this principle of selection: he rejects pleasures to secure other greater pleasures, or else he endures pains to avoid worse pains.used since the 1500s\n\"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\"\n\nSection 1.10.32 of \"de Finibus Bonorum et Malorum\", written by Cicero in 45 BC\n\"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?\"\n\n1914 translation by H. Rackham\n\"But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it? But who has any right to find fault with a man who chooses to enjoy a pleasure that has no annoying consequences, or one who avoids a pain that produces no resultant pleasure?\"\n\nSection 1.10.33 of \"de Finibus Bonorum et Malorum\", written by Cicero in 45 BC\n\"At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.\"\n\n1914 translation by H. Rackham\n\"On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire, that they cannot foresee the pain and trouble that are bound to ensue; and equal blame belongs to those who fail in their duty through weakness of will, which is the same as saying through shrinking from toil and pain. These cases are perfectly simple and easy to distinguish. In a free hour, when our power of choice is untrammelled and when nothing prevents our being able to do what we like best, every pleasure is to be welcomed and every pain avoided. But in certain circumstances and owing to the claims of duty or the obligations of business it will frequently occur that pleasures have to be repudiated and annoyances accepted. The wise man therefore always holds in these matters to this principle of selection: he rejects pleasures to secure other greater pleasures, or else he endures pains to avoid worse pains."""

  val rjson = raw""" { "_id": "6461081cc8d543af9ddc7bd3",
    "index": 0,
    "guid": "1d13f957-31ee-447c-a475-cc84a572b775",
    "isActive": true,
    "balance": "1,105.86",
    "picture": "http://placehold.it/32x32",
    "age": 33,
    "eyeColor": "blue",
    "name": "Selena King",
    "gender": "female",
    "company": "FUTURITY",
    "email": "selenaking@futurity.com",
    "phone": "+1 (826) 400-3632",
    "address": "473 Fleet Street, Abiquiu, Ohio, 5660",
    "about": "Nisi cupidatat sunt officia consequat laboris est aliquip eu incididunt ipsum. Fugiat consectetur consectetur enim anim magna. Aliquip do eu sint aliquip officia nulla laboris dolor anim. Veniam cupidatat ad nulla deserunt sit adipisicing id dolor deserunt aliquip consectetur. Sunt dolore occaecat commodo magna laborum. Elit anim eiusmod anim cillum ullamco aute dolore et culpa aliqua tempor sit et aliqua.\r\n",
    "registered": "2022-05-21T09:23:15 -09:00",
    "latitude": 45.568675,
    "longitude": -44.249786,
    "tags": [
      "enim",
      "excepteur",
      "anim",
      "qui",
      "amet",
      "velit",
      "laborum"
    ],
    "friends": [
      {
        "id": 0,
        "name": "Morin Daniels"
      },
      {
        "id": 1,
        "name": "Allyson Garner"
      },
      {
        "id": 2,
        "name": "Kristi Huber"
      }
    ],
    "greeting": "Hello, Selena King! You have 7 unread messages.",
    "favoriteFruit": "banana"
  }
"""

  val jsonString =
    raw"""{
       "frontend1": 1,"frontend": 1, "backend777": [{"이력서1": "${resume}","js": {"backend2": ["js","ts","rxjs"]}, "hi": ["hi1","hi2"]},"ts","rxjs","js","ts","rxjs","js","ts","rxjs","js","ts","rxjs","js","ts","rxjs","js","ts","rxjs","js","ts","rxjs","js","ts","rxjs","js","ts","rxjs","js","ts","rxjs","js","ts","rxjs","js","ts","rxjs","js","ts","rxjs","js","ts","rxjs","js","ts","rxjs","js","ts","rxjs"], "fronatend": 19,"designer": {"d": "A", "e": "B"}, "marketer": "null", "g": {"h": [6,7,8], "i": 9,"frontend": 1},
       "frontend2": 1,"frontend2": 1, "backend2": ["js","ts","rxjs"], "fronsdtend": 19,"designer": {"d": "A", "e": "B"}, "marketer": "null", "g": {"h": [6,7,8], "i": 9,"frontend": 1},
       "frontend3": 1,"frontend3": 1, "backend3": ["js","ts","rxjs"], "frontednd": 19,"designer": {"d": "A", "e": "B"}, "marketer": "null", "g": {"h": [6,7,8], "i": 9,"frontend": 1},
       "frontend13": 1,"fronten4d": 1, "backend3": ["js","ts","rxjs"], "frontasdend": 19,"designer": {"d": "A", "e": "B"}, "marketer": "null", "g": {"h": [6,7,8], "i": 9,"frontend": 1},
       "frontend23": 1,"frofnten2d": 1, "backend3": ["js","ts","rxjs"], "frontenda": 19,"designer": {"d": "A", "e": "B"}, "marketer": "null", "g": {"h": [6,7,8], "i": 9,"frontend": 1},
       "frontend33": 1,"fronsten2d": 1, "backend3": ["js","ts","rxjs"], "frontednd": 19,"designer": {"d": "A", "e": "B"}, "marketer": "null", "g": {"h": [6,7,8], "i": 9,"frontend": 1},
       "frontend33": 1,"fronte2n2d": 1, "backend3": ["js","ts","rxjs"], "frontednd": 19,"designer": {"d": "A", "e": "B"}, "marketer": "null", "g": {"h": [6,7,8], "i": 9,"frontend": 1},
       "frontend43": 1,"fronten3d": 1, "backend3": ["js","ts","rxjs"], "frontefnd": 19,"designer": {"d": "A", "e": "B"}, "marketer": "null", "g": {"h": [6,7,8], "i": 9,"frontend": 1},
       "frontend53": 1,"frontaen4d": 1, "backend3": ["js","ts","rxjs"], "frontenqwd": 19,"designer": {"d": "A", "e": "B"}, "marketer": "null", "g": {"h": [6,7,8], "i": 9,"frontend": 1},
       "frontend53": 1,"fronten4d": 1, "backend3": ["js","ts","rxjs"], "frontenqwd": 19,"designer": {"d": "A", "e": "B"}, "marketer": "null", "g": {"h": [6,7,8], "i": 9,"frontend": 1},
       "frontend14": 1,"fronten5d": 1, "backend4": ["js","ts","rxjs"], "frontende": 19,"designer": {"d": "A", "e": "B"}, "marketer": "null", "g": {"h": [6,7,8], "i": 9,"frontend": 1}
    }"""

  def getJsonData(jsonString: String) =
    decode[Json](jsonString) match {
      case Left(error) => {
        Json.True
      }
      case Right(data) => data
    }
