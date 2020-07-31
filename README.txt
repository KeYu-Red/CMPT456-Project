Apache Lucene/Solr

lucene/ is a search engine library
solr/ is a search engine server that uses lucene

To compile the sources run 'ant compile'
To run all the tests run 'ant test'
To setup your ide run 'ant idea', 'ant netbeans', or 'ant eclipse'
For Maven info, see dev-tools/maven/README.maven

For more information on how to contribute see:
http://wiki.apache.org/lucene-java/HowToContribute
http://wiki.apache.org/solr/HowToContribute

//////////////////////////////////
Project Cmpt456

docker run -t -d --name "keyuk_cmpt456" bb8ed86a0cda
docker exec -it keyuk_cmpy456 /bin/bash

docker cp "path_to_file_on_your_computer" "dockerContainerid:/lucene-solr/path_where_you_want_this_saved"
docker start id

docker cp ./lucene/demo/build.xml e1e084ac7920:/lucene-solr/lucene/demo;


docker cp ./lucene/demo/src/java/org/apache/lucene/demo/HtmlIndexFiles.java e1e084ac7920:/lucene-solr/lucene/demo/src/java/org/apache/lucene/demo;
docker cp ./lucene/demo/src/java/org/apache/lucene/demo/SearchFiles.java e1e084ac7920:/lucene-solr/lucene/demo/src/java/org/apache/lucene/demo;
docker cp ./lucene/demo/src/java/org/apache/lucene/demo/SimpleMetrics.java e1e084ac7920:/lucene-solr/lucene/demo/src/java/org/apache/lucene/demo;
docker cp ./lucene/demo/src/java/org/apache/lucene/demo/CMPT456Analyzer.java e1e084ac7920:/lucene-solr/lucene/demo/src/java/org/apache/lucene/demo;
docker cp ./lucene/demo/src/java/org/apache/lucene/demo/StopWords.txt e1e084ac7920:/lucene-solr/lucene/demo/src/java/org/apache/lucene/demo;
docker cp ./lucene/demo/src/java/org/apache/lucene/demo/TFIDFHtmlIndexFiles.java e1e084ac7920:/lucene-solr/lucene/demo/src/java/org/apache/lucene/demo;
docker cp ./lucene/demo/src/java/org/apache/lucene/demo/TFIDFSearchFiles.java e1e084ac7920:/lucene-solr/lucene/demo/src/java/org/apache/lucene/demo;
docker cp ./lucene/demo/build.xml e1e084ac7920:/lucene-solr/lucene/demo;


ant -f lucene/demo/build.xml \
-Ddocs=lucene/demo/data/wiki-small/en/articles/ run-indexing-demo

ant -f lucene/demo/build.xml \
-Ddocs=lucene/demo/data/wiki-small/en/articles/ run-html-indexing-demo

ant -f lucene/core/build.xml; ant -f lucene/demo/build.xml

ant -f lucene/demo/build.xml run-search-index-demo