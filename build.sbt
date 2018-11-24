

ThisBuild / name := "LearningFinagleThrift"
ThisBuild / version := "1.0.0"

lazy val main = (project in file("."))
.settings(
  scalaVersion := "2.12.7",
  libraryDependencies ++= Seq(
    "org.apache.thrift" % "libthrift" % "0.9.2",
    "com.twitter" %% "scrooge-core" % "4.13.0" exclude("com.twitter", "libthrift"),
    "com.twitter" %% "finagle-thrift" % "18.9.0" exclude("com.twitter", "libthrift")
  ),
).enablePlugins(ScroogeSBT)

scroogeThriftIncludeFolders in Compile := Seq(baseDirectory {
  base => base / "src/main/thrift"
}.value)

scroogeThriftOutputFolder in Compile  := baseDirectory {
  base => base / "src/main/scala"
}.value

scroogeLanguages in Compile := Seq("scala")
