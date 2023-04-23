package app

// enum PageCase(name: String = "", url: String = ""):
enum PageCase:
  case Page_Finders(
      name: String = "content_copy"
      // onClick: PageMsg = PageMsg.PreUpdate(PageCase.Page_Finders())
      // url: String = "Observer",
      // pubs: List[PubCase] = List(new PubCase.BoardPub),
      // status: Boolean = false,
  ) extends PageCase

  case Page_Searchs(
      name: String = "search"
      // url: String = "dashboard",
      // pubs: List[PubCase] = List(
      //   new PubCase.BlockPub,
      //   new PubCase.TxPub,
      //   new PubCase.BoardPub,
      // ),
      // status: Boolean = false,
  ) extends PageCase
