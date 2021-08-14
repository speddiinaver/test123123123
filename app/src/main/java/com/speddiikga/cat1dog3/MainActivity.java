package com.speddiikga.cat1dog3;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.LruCache;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.io.ByteArrayOutputStream;

class MainActivity extends Activity {
    ImageView imageView;
    Button button;
    TextView textView;
    TextView textView2;
    Uri imageUri;
    //String url ="http://127.0.0.1:8000/blog/catdogapi/";
    private static final int PICK_IMAGE = 100;
    @SuppressLint({"WrongThread", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button.setOnClickListener(v -> {
            Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
            startActivityForResult(gallery, PICK_IMAGE);
            //final TextView textView2 = (TextView) findViewById(R.id.text2);
        });}


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageUri = data.getData();
            imageView.setImageURI(imageUri);}}}
            /*ByteArrayOutputStream bas = new ByteArrayOutputStream();
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.id.imageView);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 10, bas);
            byte[] imageBytes = bas.toByteArray();
            String imageString = Base64.encodeToString(imageBytes, Base64.DEFAULT);
            textView.setText(imageString);
            textView2.setText(imageString);
        }
    }
    public static class MySingleton {
        @SuppressLint("StaticFieldLeak")
        private static MySingleton instance;
        private RequestQueue requestQueue;
        private final ImageLoader imageLoader;
        @SuppressLint("StaticFieldLeak")
        private static Context ctx;

        private MySingleton(Context context) {
            ctx = context;
            requestQueue = getRequestQueue();

            imageLoader = new ImageLoader(requestQueue,
                    new ImageLoader.ImageCache() {
                        private final LruCache<String, Bitmap>
                                cache = new LruCache<String, Bitmap>(20);
                        @Override
                        public Bitmap getBitmap(String url) {
                            return cache.get(url);
                        }
                        @Override
                        public void putBitmap(String url, Bitmap bitmap) {
                            cache.put(url, bitmap);
                        }
                    });
        }
        public static synchronized MySingleton getInstance(Context context) {
            if (instance == null) {
                instance = new MySingleton(context);
            }
            return instance;
        }

        public RequestQueue getRequestQueue() {
            if (requestQueue == null) {
                requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
            }
            return requestQueue;
        }
        public <T> void addToRequestQueue(Request<T> req) {
            getRequestQueue().add(req);
        }
        public ImageLoader getImageLoader() {
            return imageLoader;
        }
    }
}*/