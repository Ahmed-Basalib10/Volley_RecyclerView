# Volley_RecyclerView
JISON parsing using volley

## What is Volley ?
Volley is an HTTP network library that makes networking for android apps easier ,faster and without a lot of code.\
Volley is developed by Google.

By using Volley for network operations you avoid the standard way to handle networking, HttpURLConnection.\
 Another reason is asynchronicity. Volley handles asynchronicity by itself, there is no need to create Asynctask manually.
In volley there are 3 threads:
1. Main Thread
2. Cache Thread
3. Network Thread


As we see in the photo the main thread will send request to CacheDispatcher, CacheDispatcher will send request to Cache Thread
Cache thread will search for data in cache memory if the data exist then it is cache hit and will send response to CacheDispatcher.
CacheDispatcher will send the response to the main thread. If the data is not exist
in cache memory then it is cache miss so CacheDispatcher will send request to network thread , network thread will send Http request 
to the server , the server will send Http response to Network thread,Network thread will send this response to main thread as well as to 
Cache thread.


Steps to Implement volley:
step 1 : Add the dependency in build.gradle(Module: app)

dependencies {
    ...
    implementation 'com.android.volley:volley:1.1.1'
}

step 2: Create / Set up the RequestQueue

RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //...
        requestQueue = Volley.newRequestQueue(this); // 'this' is the Context

    }

for best practice create create RequestQueue using Singleton class.

step 3: Create standrad request there are many requests:
