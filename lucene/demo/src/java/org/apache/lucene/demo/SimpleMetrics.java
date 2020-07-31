/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.lucene.demo;


//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
import java.io.*;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.lang.Long;


import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;

import org.apache.lucene.util.*;

/** Simple command-line based search demo. */
public class SimpleMetrics {

    private SimpleMetrics() {
    }
    /**
     * Simple command-line based search demo.
     */
    public static void main(String[] args) throws Exception {
        String index = "index";
        String field = "contents";


        IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(index)));
        File file = new File("/lucene-solr/lucene/demo/src/java/org/apache/lucene/demo/StopWords.txt");
        Reader br = new FileReader(file);
        Analyzer analyzer = new CMPT456Analyzer(br);

        while(true){
            System.out.println("Input your query: ");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String queryString = in.readLine();
            String line = queryString.trim();
            System.out.println("Query String: "+line);

            QueryParser parser = new QueryParser(field, analyzer);
            Query query = parser.parse(line);
            String [] queryStrings = query.toString().split(" +");

            final int lengthOfTerm = queryStrings.length;

            long documentFrequency = 0;
            long maxDoc = 0;
            long termFrequency = 0;
            long maxTerm = 0;

            for(int i=0; i< lengthOfTerm; i++) {
                System.out.println("queryString = " + queryStrings[i]);
                String[] qStr = queryStrings[i].split(":");
                Term queryTerm = new Term(field, qStr[1]);
                //documentFrequency
                documentFrequency = reader.docFreq(queryTerm);
                if (documentFrequency >= maxDoc)
                    maxDoc = documentFrequency;
                //termFrequency
                termFrequency = reader.totalTermFreq(queryTerm);
                if (termFrequency >= maxTerm)
                    maxTerm = termFrequency;

            }
            System.out.println("documentFrequency = "+ maxDoc);
            System.out.println("termFrequency     = "+ maxTerm);
            System.out.println("*******************\ncontinue(c), quit(q)");

            Scanner sc= new Scanner(System.in); //System.in is a standard input stream
            String str= sc.nextLine();              //reads string
            //System.out.println("choice = "+str);
            if(str == "q"){
                break;
            }
        }



        reader.close();
    }
}
