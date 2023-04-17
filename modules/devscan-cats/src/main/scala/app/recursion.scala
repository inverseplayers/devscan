// def loop(accounts: List[Account]): EitherT[F, String, Unit] =
//   accounts match
//     case Nil => EitherT.pure(())
//     case account :: tail =>
//       updateAccount(accounts).value.flatMap {
//         case Left(msg) =>
//           scribe.error(s"Error: $msg")
//           Async[F].sleep(1000.millis) *> loop(accounts)
//         case Right(result) =>
//           loop(tail)
//       }

// def updateAccount(account: Account): EitherT[F, String, Unit] = ???
