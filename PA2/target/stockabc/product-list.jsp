<!DOCTYPE html>
<html lang="en">

<head>
    <title>Products</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./resources/css/productlist.css">
    <link rel="stylesheet" href="./resources/css/productslist.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="./js/product.js"></script>
</head>

<body>

    <header>
        <div class="nav-bar-container">
            <ul class="nav-bar">
                <li class="nav-bar-title">Products</li>
                <li class="tab"><a href="./index.jsp">Home</a></li>
                <li class="tab"><a href="">Products</a></li>
                <li class="tab"><a href="./team.jsp">The Team</a></li>
            </ul>
        </div>
    </header>

    <div class="products-container">
        <!-- DUNK LOW (UNIVERSITY BLUE) -->
        <div id="p1" class="product" onclick="handleProductSelect(this.id)">
            <!-- <img src="./images/p1/university_blue_dunks.jpg" class="product-img" style="padding-top: 15%; padding-bottom: 5%;"> -->
            <div class="product-imgs">
                <img src="./images/p1/bluedunks1.jpg" class="product-img">
                <img src="./images/p1/bluedunks2.jpg" class="additional-product-img">
                <img src="./images/p1/bluedunks3.jpg" class="additional-product-img">
                <img src="./images/p1/bluedunks4.jpg" class="additional-product-img">
            </div>
            <div class="product-description">
                <div class="product-name">Dunk Low (University Blue)</div>
                <div class="product-type">Nike</div>
                <div class="product-price">$100</div>
                <div class="product-review">78 reviews</div>
                <div class="product-hidden-desc">Originally created for the hardwood, the Dunk later took to the
                    streets—and as they say, the rest is history. More than 35 years after its debut, the silhouette
                    still delivers bold, defiant style and remains a coveted look for crews across both sport and
                    culture. Now, the university-hoops OG returns, covered in crisp material overlays with
                    heritage-inspired colour-blocking. Modern footwear technology brings the design's comfort into the
                    21st century, while a clean combination of white and University Blue gives this make-up a classic
                    feel.
                </div>
            </div>
        </div>
        <div id="p2" class="product" onclick="handleProductSelect(this.id)">
            <!-- <img src="./images/white_af.jpg" class="product-img"> -->
            <div class="product-imgs">
                <img src="./images/p2/white_af1.jpg" class="product-img">
                <img src="./images/p2/white_af2.jpg" class="additional-product-img">
                <img src="./images/p2/white_af3.jpg" class="additional-product-img">
                <img src="./images/p2/white_af4.jpg" class="additional-product-img">
            </div>
            <div class="product-description">
                <div class="product-name">Air Force 1 (White)</div>
                <div class="product-type">Nike</div>
                <div class="product-price">$100</div>
                <div class="product-review">103 reviews</div>
                <div class="product-hidden-desc">The radiance lives on in the Nike Air Force 1 ’07, the b-ball OG that
                    puts a fresh spin on what you know best: durably stitched overlays, clean finishes and the perfect
                    amount of flash to make you shine.
                </div>
            </div>
        </div>
        <div id="p3" class="product" onclick="handleProductSelect(this.id)">
            <div class="product-imgs">
                <img src="./images/p3/AirMax95_teal.jpg" class="product-img">
                <img src="./images/p3/AirMax95_teal2.jpg" class="additional-product-img">
                <img src="./images/p3/AirMax95_teal3.jpg" class="additional-product-img">
                <img src="./images/p3/AirMax95_teal4.jpg" class="additional-product-img">
            </div>
            <div class="product-description">
                <div class="product-name">Air Max 95 (Sesame, Teal, Amethyst)</div>
                <div class="product-type">Nike</div>
                <div class="product-price">$151</div>
                <div class="product-review">65 reviews</div>
                <div class="product-hidden-desc">Nike is back yet again to reimagine its classic 95 silhouette in a
                    fresh spring colourway. Inspired by the human body and 90’s track aesthetics, the uppers are crafted
                    from at least 20% recycled materials and overlaid with suede, then detailed with hits of cream and
                    purple on the wavy side wall which represent muscle strength. Underfoot, it’s fitted with a visible
                    air sole unit which provides supreme cushioning with every step.
                </div>
            </div>
        </div>
        <div id="p4" class="product" onclick="handleProductSelect(this.id)">
            <div class="product-imgs">
                <img src="./images/p4/conv_oneStar1.jpg" class="product-img">
                <img src="./images/p4/conv_oneStar2.jpg" class="additional-product-img">
                <img src="./images/p4/conv_oneStar3.jpg" class="additional-product-img">
                <img src="./images/p4/conv_oneStar4.jpg" class="additional-product-img">
            </div>
            <div class="product-description">
                <div class="product-name">One Star (White & Black)</div>
                <div class="product-type">Converse</div>
                <div class="product-price">$68</div>
                <div class="product-review">39 reviews</div>
                <div class="product-hidden-desc">This Converse One Star is a staple since it was established in 1974 and
                    now gets a special edition look inspired by underground rave culture from the '90s. Crafted with a
                    suede upper and warped, blocky graphics, the low-top retro sneaker from Converse features a
                    cushioned OrthoLite insole and 100% recycled mesh lining for a sustainable finish.
                </div>
            </div>
        </div>
        <div id="p5" class="product" onclick="handleProductSelect(this.id)">
            <div class="product-imgs">
                <img src="./images/p5/JScott_Forum.jpg" class="product-img">
                <img src="./images/p5/JScott_Forum2.jpg" class="additional-product-img">
                <img src="./images/p5/JScott_Forum3.jpg" class="additional-product-img">
                <img src="./images/p5/JScott_Forum4.jpg" class="additional-product-img">
            </div>
            <div class="product-description">
                <div class="product-name">JEREMY SCOTT FORUM WINGS 1.0 MONEY (CLEAR BROWN & GREEN NIGHT)</div>
                <div class="product-type">Adidas</div>
                <div class="product-price">$149</div>
                <div class="product-review">63 reviews</div>
                <div class="product-hidden-desc">The adidas Forum Jeremy Scott Wings 1.0 Money is monumental in Scott's
                    catalog with adidas - it is the first design they ever released. The Wings 1.0 Money stays true to
                    the original with a leather upper fully decorated in a patchwork currency print and dark green
                    leather three stripe overlays. Following Scott's charismatic style, leather wings jet off of the
                    lateral eyestay to complete this monetary masterpiece.
                    The adidas Forum Jeremy Scott Wings 1.0 Money released in August of 2021 and retailed for $160.
                </div>
            </div>
        </div>
        <div id="p6" class="product" onclick="handleProductSelect(this.id)">
            <div class="product-imgs">
                <img src="./images/p6/Forum_Mid.jpg" class="product-img">
                <img src="./images/p6/Forum_Mid2.jpg" class="additional-product-img">
                <img src="./images/p6/Forum_Mid3.jpg" class="additional-product-img">
                <img src="./images/p6/Forum_Mid4.jpg" class="additional-product-img">
            </div>
            <div class="product-description">
                <div class="product-name">Forum Mid (White & Royal Blue)</div>
                <div class="product-type">Adidas</div>
                <div class="product-price">$114</div>
                <div class="product-review">42 reviews</div>
                <div class="product-hidden-desc">Let's take a moment to honor an icon. Is it the gravity-defying B-ball
                    legend from the '80s? Or perhaps the status shoe that adorned the feet of rappers? Both, in fact.
                    The adidas Forum shoes have dominated the hardwood and the streets, and they're back in a mid top
                    version to take your moves to the next level. Slip into the unmistakable style, now in luxurious
                    coated leather, and flaunt that pure class.
                </div>
            </div>
        </div>
        <div id="p7" class="product" onclick="handleProductSelect(this.id)">
            <div class="product-imgs">
                <img src="./images/p7/MS327LF1.jpg" class="product-img">
                <img src="./images/p7/MS327LF1_2.jpg" class="additional-product-img">
                <img src="./images/p7/MS327LF1_3.jpg" class="additional-product-img">
                <img src="./images/p7/MS327LF1_4.jpg" class="additional-product-img">
            </div>
            <div class="product-description">
                <div class="product-name">MS327LF1 (Black)</div>
                <div class="product-type">New Balance</div>
                <div class="product-price">$100</div>
                <div class="product-review">51 reviews</div>
                <div class="product-hidden-desc">As recreational running established widespread popularity in the 1970s,
                    the benchmark for running footwear shifted from mere existence to performance. While the era’s
                    designs would be considered simple by today’s standards, the decade stands out as the moment when
                    running shoes truly came into their own. The 327 sheds new light on the ‘70s as a time of innovation
                    by boldly reshaping classic design elements with a thoroughly contemporary outlook. With an angular
                    reworking of the tried-and-true wedge silhouette, outsize, asymmetrically applied ‘N’ branding, and
                    wraparound, trail-inspired lug outsole, the 327 provides nothing less than a complete reimagination
                    of our running heritage.
                </div>
            </div>
        </div>
        <div id="p8" class="product" onclick="handleProductSelect(this.id)">
            <div class="product-imgs">
                <img src="./images/p8/ML574RO2.jpg" class="product-img">
                <img src="./images/p8/ML574RO2_2.jpg" class="additional-product-img">
                <img src="./images/p8/ML574RO2_3.jpg" class="additional-product-img">
                <img src="./images/p8/ML574RO2_4.jpg" class="additional-product-img">
            </div>
            <div class="product-description">
                <div class="product-name">ML574RO2 (Nightwatch Green)</div>
                <div class="product-type">New Balance</div>
                <div class="product-price">$90</div>
                <div class="product-review">64 reviews</div>
                <div class="product-hidden-desc">The 574 is right back like it never left. The ENCAP midsole cushioning
                    that is utilized in this sneaker combines both lightweight foams and durable polyurethane rim to
                    deliver optimal support, and all-day comfort.
                </div>
            </div>
        </div>
        <div id="p9" class="product" onclick="handleProductSelect(this.id)">
            <div class="product-imgs">
                <img src="./images/p9/conv_runStar.jpg" class="product-img">
                <img src="./images/p9/conv_runStar2.jpg" class="additional-product-img">
                <img src="./images/p9/conv_runStar3.jpg" class="additional-product-img">
                <img src="./images/p9/conv_runStar4.jpg" class="additional-product-img">
            </div>
            <div class="product-description">
                <div class="product-name">Run Star Hike (Black, White, Gum)</div>
                <div class="product-type">Converse</div>
                <div class="product-price">$110</div>
                <div class="product-review">115 reviews</div>
                <div class="product-hidden-desc">A chunky platform and jagged rubber sole put an unexpected twist on
                    your everyday Chucks. Details like a canvas build, rubber toe cap and Chuck Taylor ankle patch stay
                    true to the original, while a molded platform, two-tone outsole and rounded heel give off futuristic
                    vibes.
                </div>
            </div>
        </div>
        <div id="p10" class="product" onclick="handleProductSelect(this.id)">
            <div class="product-imgs">
                <img src="./images/p10/superstar_recon.jpg" class="product-img">
                <img src="./images/p10/superstar_recon2.jpg" class="additional-product-img">
                <img src="./images/p10/superstar_recon3.jpg" class="additional-product-img">
                <img src="./images/p10/superstar_recon4.jpg" class="additional-product-img">
            </div>
            <div class="product-description">
                <div class="product-name">Superstar Recon Sneakers</div>
                <div class="product-type">Adidas</div>
                <div class="product-price">$136</div>
                <div class="product-review">80 reviews</div>
                <div class="product-hidden-desc">First introduced back in 1971, adidas' Superstar Recon sneaker
                    continues to stand the test of time. Crafted from white leather, this iteration of the iconic shoe
                    pays tribute to the first-ever pair, removing the now-famous Trefoil heel counter and replacing it
                    with the sleek version seen on the original.
                </div>
            </div>
        </div>
        <div id="p11" class="product" onclick="handleProductSelect(this.id)">
            <div class="product-imgs">
                <img src="./images/p11/ChuckTaylorAllStarClassic.jpg" class="product-img">
                <img src="./images/p11/ChuckTaylorAllStarClassic2.jpg" class="additional-product-img">
                <img src="./images/p11/ChuckTaylorAllStarClassic3.jpg" class="additional-product-img">
                <img src="./images/p11/ChuckTaylorAllStarClassic4.jpg" class="additional-product-img">
            </div>
            <div class="product-description">
                <div class="product-name">Chuck Taylor All Star Classic (Navy)</div>
                <div class="product-type">Converse</div>
                <div class="product-price">$65</div>
                <div class="product-review">130 reviews</div>
                <div class="product-hidden-desc">We could tell you that it’s the OG basketball shoe, created over 100
                    years ago. Or that the design has largely stayed the same, because why mess with a good thing. Or
                    how it became the unofficial sneaker of all your favorite artists and musicians, who each made it
                    their own. Yeah, we could share a lot of stories, but the one that matters most isn’t ours—it’s
                    yours. It’s how and where you take your Chucks. The legacy is long, but what comes next is up to
                    you. We just make the shoe. You make the stories.
                </div>
            </div>
        </div>
    </div>

    <footer>
        Made with brains by: Katie Chow, Andrew Owyang, and Huan Nguyen
    </footer>
</body>

</html>