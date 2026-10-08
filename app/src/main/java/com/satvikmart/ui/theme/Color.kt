package com.satvikmart.util

import com.satvikmart.data.database.entity.CouponEntity
import com.satvikmart.data.database.entity.ProductEntity

object SampleDataGenerator {
    fun generateProducts(): List<ProductEntity> = listOf(
        ProductEntity("p1","Satvik Shuddh Atta","Satvik Mart","Shuddh Atta & Staples","Whole wheat flour",159.0,129.0,18,"kg","5 kg",30,4.5f,120,"https://images.unsplash.com/photo-1571781926291-c477ebfd024b?auto=format&fit=crop&w=900&q=80","atta,wheat,staples", true),
        ProductEntity("p2","Royal Basmati Rice","Satvik Mart","Shuddh Atta & Staples","Premium rice",260.0,219.0,16,"kg","5 kg",22,4.7f,190,"https://images.unsplash.com/photo-1586201375761-83865001e31e?auto=format&fit=crop&w=900&q=80","rice,basmati,staples", true),
        ProductEntity("p3","Toor Dal","Satvik Mart","Dal & Pulses","Protein rich pulse",170.0,149.0,12,"kg","1 kg",50,4.4f,210,"https://images.unsplash.com/photo-1604908553252-4d6db7f6b4b9?auto=format&fit=crop&w=900&q=80","dal,pulses,protein", false),
        ProductEntity("p4","Pure Desi Ghee","Satvik Mart","Desi Ghee & Cooking Essentials","Traditional ghee",550.0,499.0,9,"L","1 L",18,4.8f,260,"https://images.unsplash.com/photo-1631312319018-08476669611f?auto=format&fit=crop&w=900&q=80","ghee,desi,cooking", true),
        ProductEntity("p5","Neem Herbal Toothpaste","Satvik Mart","Herbal & Ayurvedic Care","Herbal toothpaste",120.0,99.0,17,"tube","100 g",40,4.3f,150,"https://images.unsplash.com/photo-1607619056574-7b8d3ee536b2?auto=format&fit=crop&w=900&q=80","herbal,toothpaste,ayurvedic", false),
        ProductEntity("p6","Roasted Makhana","Satvik Mart","Healthy Snacks","Roasted snack",120.0,95.0,20,"pack","100 g",70,4.5f,130,"https://images.unsplash.com/photo-1512621776951-a57141f2eefd?auto=format&fit=crop&w=900&q=80","snacks,healthy,makhana", true),
        ProductEntity("p7","Fresh Cow Milk","Satvik Mart","Dairy Products","Toned milk",52.0,44.0,15,"L","1 L",60,4.7f,230,"https://images.unsplash.com/photo-1550583724-b2692b85b150?auto=format&fit=crop&w=900&q=80","milk,dairy,breakfast", true),
        ProductEntity("p8","Fresh Tomatoes","Satvik Mart","Fresh Vegetables","Farm tomatoes",50.0,42.0,16,"kg","1 kg",90,4.4f,170,"https://images.unsplash.com/photo-1546094096-0df4bcaaa337?auto=format&fit=crop&w=900&q=80","vegetable,tomato,fresh", false),
        ProductEntity("p9","Apple","Satvik Mart","Fresh Fruits","Fresh red apple",190.0,155.0,18,"kg","1 kg",75,4.6f,180,"https://images.unsplash.com/photo-1567306226416-28f0efdc88ce?auto=format&fit=crop&w=900&q=80","fruit,apple,healthy", false),
        ProductEntity("p10","Pooja Camphor","Satvik Mart","Pooja Samagri","Temple essentials",120.0,99.0,18,"box","50 g",25,4.7f,95,"https://images.unsplash.com/photo-1603056799305-4998a62d8b8a?auto=format&fit=crop&w=900&q=80","pooja,camphor,samagri", true)
    )

    fun generateCoupons(): List<CouponEntity> = listOf(
        CouponEntity("c1","SATVIK50",50.0,"FIXED",300.0,50.0,System.currentTimeMillis()+86400000L*30, true,"₹50 off on orders above ₹300"),
        CouponEntity("c2","WELCOME100",100.0,"FIXED",500.0,100.0,System.currentTimeMillis()+86400000L*40, true,"Welcome offer"),
        CouponEntity("c3","SAVE10",10.0,"PERCENTAGE",200.0,80.0,System.currentTimeMillis()+86400000L*20, true,"10% off"),
        CouponEntity("c4","FIRSTORDER",75.0,"FIXED",400.0,75.0,System.currentTimeMillis()+86400000L*15, true,"Exclusive first order")
    )
}
