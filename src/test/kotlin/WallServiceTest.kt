import org.junit.Assert.*
import org.junit.Test

class WallServiceTest {
    private val reposts = Reposts()
    private val views = ViewsObject()

    private val post = Post(
        id = 0,
        ownerId = 1,
        createdBy = 1,
        date = 1234,
        text = "Текст №1",
        replyPostId = 5,
        friendsOnly = false,
        reposts = reposts,
        views = views,
        postType = "post",
        attachments = null,
        canDelete = true,
        canEdit = true,
    )

    private val comment =
        Comment(ownerId = 1, postId = 2, message = "Комментарий к посту", replyToComment = 0, stickerId = 0, guid = "")

    @Test
    fun addTest() {
        val service = WallService()
        service.add(post.copy(text = "Текст №2"))
        service.add(post.copy(text = "Текст №3", views = ViewsObject()))
        val testPost = post.copy(text = "Новый текст")
        val result = service.add(testPost)
        assertEquals(testPost.copy(id = 2), result)
    }

    @Test
    fun updateTest() {
        val service = WallService()
        service.add(post)
        service.add(post.copy(text = "Текст №2"))
        service.add(post.copy(text = "Текст №3 ", reposts = reposts))
        val update = post.copy(id = 2, text = "Текст №3")
        val result = service.update(update)
        assertTrue(result)
    }

    @Test
    fun updateNotValidTest() {
        val service = WallService()
        service.add(post)
        service.add(post.copy(text = "Текст №"))
        service.add(post.copy(text = "Текст №3 "))
        val update = post.copy(id = 100, text = "Новый текст")
        val result = service.update(update)
        assertFalse(result)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrowTest() {
        val service = WallService()
        service.add(post)
        service.add(post.copy(text = "Текст №2"))
        service.createComment(comment)
    }
}