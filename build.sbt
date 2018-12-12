lazy val akkaHttpVersion = "10.1.5"
lazy val akkaVersion    = "2.5.18"
resolvers += Resolver.sbtPluginRepo("releases")
lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization    := "com.estafet",
      scalaVersion    := "2.12.7"
    )),
    name := "doc1",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http"            % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-http-xml"        % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-stream"          % akkaVersion,

      "com.typesafe.akka" %% "akka-http-testkit"    % akkaHttpVersion % Test,
      "com.typesafe.akka" %% "akka-testkit"         % akkaVersion     % Test,
      "com.typesafe.akka" %% "akka-stream-testkit"  % akkaVersion     % Test,
      "org.scalatest"     %% "scalatest"            % "3.0.5"         % Test 
    )
  )
enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)
dockerBaseImage       := "openjdk:jre-alpine"
mainClass in Compile := Some("com.estafet.QuickstartServer")
enablePlugins(AshScriptPlugin)
