package com.example.finalmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar!!.title = intent.getStringExtra("Intent_title")
        Glide.with(this)
            .load(intent.getStringExtra("Intent_image"))
            .placeholder(R.drawable.img_placeholder)
            .error(R.drawable.img_placeholder)
            .into(imageView)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.share_menu){
            val shareIntent = Intent().apply {
                this.action = Intent.ACTION_SEND
                this.type = "text/plain"
                this.putExtra(Intent.EXTRA_TEXT, intent.getStringExtra("Intent_image"))
            }
            startActivity(shareIntent)
        }else{
            return super.onOptionsItemSelected(item)
        }
        return true
    }
}