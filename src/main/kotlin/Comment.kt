class Comment(
    val ownerId: Int,
    val postId: Int,
    val fromGroup: Int = 0,
    val message: String,
    val replyToComment: Int,
    val stickerId: Int,
    val guid: String
)