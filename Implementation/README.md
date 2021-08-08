Add E-Books:

System admin will collect the e books of all the library books available and add those books to the VR System where students can be able to access those e-books through a VR headset. System admin will then update and maintain the library resources as required by the VR System. The server side stores the book and model data of the virtual digital library system. At the same time, the core system of virtual library is running on the server side, and responds to the requests of the user from the client. The server communicates with the database when necessary to query, add or delete the data. The database contains book information, user information, and others. A web application has been designed for the admin, who can upload ebooks in pdf format. The pdf file is processed by the server to extract the text content from it. The complete text is processed for text summarization. Users can listen and read the summary before reading the ebook.
 
 Text extraction Method:
 
We used apache pdfbox to extract the text from the pdf format. Apache PDFBox is a Java library that makes creating and converting PDF documents easier. You can use this library to build, convert, and manipulate PDF documents in Java programs. In addition, PDFBox provides a command-line tool that can be used to perform different operations on PDF files using the available Jar file. 

Text summarization Methods :

Gensim Summarizer: In the Gensim summarization module, TextRank, an unsupervised algorithm based on weighted summarization is implemented. It is based on the well-known PageRank algorithm. 

The PageRank algorithm generates a probability distribution that is used to reflect the likelihood that an individual clicking on random links would end up on a specific page. PageRank can be measured for any size range of documents. Several research papers presume that at the start of the statistical process, the distribution is uniformly distributed among all documents in the set.
The PageRank computations necessitate multiple passes through the array, referred to as "iterations," in order to get approximate PageRank values to fit the theoretical true value more closely.A probability is a number between 0 and 1 that represents the likelihood of anything happening. A "50 percent chance" of anything occurring is generally expressed as a 0.5 probability.
 
Text Rank: 

TextRank is based on the Google Search Engine's page Rank algorithm. To put it another way, it favors pages with a higher number of visitors. The ties between pages are traditionally represented as a matrix, as seen in the image below. This matrix is converted to a transfer probability matrix by dividing the number of links on each page that affect the surfer's path.

LexRank  in Text Summarization :

LexRank is an unsupervised graph-based methodology that is similar to TextRank. LexRank uses IDF-modified Cosine as the similarity metric to evaluate two sentences. This similarity determines the weight of the graph edge between two sentences. LexRank also has an intelligent post-processing stage that makes sure the top sentences chosen for the description aren't too close. LexRank is another graph-based method for summarization. It is similar to TextRank and unsupervised in nature. LexRank uses Cosine similarity instead of Jaccard between two sentences. This similarity score will be used to build a weighted graph for all the sentences in the document. LexRank also ensures that the top most sentences are not too similar to one another.


Latent Semantic Analysis (LSA) in Text Summarization:

LSA preserves as much information as possible by projecting data into a lower-dimensional vacuum. Singular vectors may be used to capture and describe patterns of repeated word combinations in a corpus.according to one interpretation of this spatial decomposition operation. The singular value's magnitude indicates the pattern's significance in a text.
Occurrence matrix:
LSA may use a document-term matrix to describe the occurrences of terms in documents. It's a sparse matrix with rows corresponding to words and columns corresponding to documents. A typical example of matrix element weighting is the tf-idf (term frequency–inverse document frequency) weighting scheme.A matrix element's weight is proportional to how many times the words appear in each document, with uncommon terms receiving a higher weight to represent their relative importance.
Rank reduction:
After the construction of the occurrence matrix, LSA finds a low-rank approximation to the term-document matrix. There could be various reasons for these approximations:
The original term-document matrix is presumed too large for the computing resources; in this case, the approximated low rank matrix is interpreted as an approximation (a "least and necessary evil").
The original term-document matrix is presumed noisy: for example, anecdotal instances of terms are to be eliminated. From this point of view, the approximated matrix is interpreted as a de-noisified matrix (a better matrix than the original).
The original term-document matrix is presumed to be overly sparse relative to the "true" term-document matrix. That is, the original matrix lists only the words in each document, whereas we might be interested in all words related to each document-generally a much larger set due to synonymy.

As a result of the rank reduction, several measurements have been merged and are dependent on multiple terms:
(car), (truck), and (flower) are all words that can be used to describe a vehicle, a truck, or a flower —- (flower) = (1.3452 * car + 0.2828 * truck),
The problem of identifying synonymy is alleviated since the rank lowering is meant to combine the dimensions associated with terms that have similar definitions. It also aids in the reduction of polysemy by combining the components of polysemous terms pointing in the "real" direction with the components of words with the same meaning.On the other hand, components pointed in different directions appear to even out or, at worst, be smaller than those pointing in the intended sense directions.
 
Luhn’s Summarization in Text Summarization:

Luhn’s algorithm is based on the fact that humans are creatures of habit and will repeat keywords throughout a document. More importantly, he believes that the keywords an author uses are well defined and represent a single concept or notion. Even if an author tries to use reasonable synonyms for his or her keyword, they will eventually run out and fall back to using the best word that defines the notion, which will be the keyword that is repeated the most. Running with the notion that an author will be repetitive by using a limited number of keywords to convey meaning, we can begin to rank sentences based on keyword frequency and proximity within a sentence. To determine sentence weight, we first look for significant words in a sentence, then take a subset of words in the sentence with the first and last word in the subset being a significant word. A subset is closed when four or five insignificant words are present before the next use of a significant word. Within the subset, we now count the number of times the significant word is present, then divide by the number of total words in the subset. This number will be the weight given to that sentence.
 

If a given sentence is long enough to contain multiple subsets of significant words, we simply take the higher subset score as the weight of the sentence. To generate the auto-extraction, we only need to take the highest x sentences where x is a user defined number of sentences for summary length and put the sentences back in the order they first appear. Besides just taking the highest rated sentences, it is also possible to break the text down into paragraphs and take the highest y sentences of each paragraph where y is x divided by the number of paragraphs.
 
Design VR Library:

The next phase is to design the interior of the library. Where we will make a digital representation of the physical library premise. In the design part, we will use Unreal Engine 4 for VR to create immersive experiences that are believable to the human mind. VR and mixed reality require complex scenes rendered at very high framerates. The system needs to implement basic functions such as scene building, scene roaming, and scene interaction.The system uses the Unreal engine to develop the virtual library system and uses the Unreal Studio software to model virtual buildings and other objects.


