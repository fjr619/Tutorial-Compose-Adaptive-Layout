package com.example.tutorial_compose_adaptive_layoout.data.local

import com.example.tutorial_compose_adaptive_layoout.data.Quote

/**
 * An static data store of [Quote]s. This includes both [Quote]s owned by the current user and
 * all [Quote]s of the current user's contacts.
 */
object LocalQuotesProvider {
    val allQuotes = mutableListOf(
        Quote(
            quote = "Your heart is the size of an ocean. Go find yourself in its hidden depths.",
            author = "Rumi"
        ),
        Quote(
            quote = "The Bay of Bengal is hit frequently by cyclones. The months of November and May, in particular, are dangerous in this regard.",
            author = "Abdul Kalam"
        ),
        Quote(
            quote = "If You Can'T Make It Good, At Least Make It Look Good",
            author = "Bill Gates"
        ),
        Quote(
            quote = "It is bad for a young man to sin; but it is worse for an old man to sin.",
            author = "Abu Bakr (R.A)"
        ),
        Quote(
            quote = "If You Are Out To Describe The Truth, Leave Elegance To The Tailor.",
            author = "Albert Einstein"
        ),
        Quote(
            quote = "These Capitalists Generally Act Harmoniously And In Concert, To Fleece The People.",
            author = "Abraham Lincoln"
        ),
        Quote(
            quote = "I Don'T Believe In Failure. It Is Not Failure If You Enjoyed The Process.",
            author = "Oprah Winfrey"
        ),
        Quote(
            quote = "If you even dream of beating me you'd better wake up and apologize.",
            author = "Muhammad Ali"
        ),
        Quote(
            quote = "I Will Praise Any Man That Will Praise Me",
            author = "William Shakespeare"
        ),
        Quote(
            quote = "One Of The Greatest Diseases Is To Be Nobody To Anybody.",
            author = "Mother Teresa"
        )
    )
}