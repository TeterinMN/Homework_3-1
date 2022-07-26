val service = WallService()

fun main() {
    val reposts = Reposts()
    val views = ViewsObject()
    val vId = 0
    val post = Post(
        id = vId,
        ownerId = 1,
        createdBy = 1,
        date = 1980,
        text = "Тестовый текст №1",
        replyPostId = 1,
        friendsOnly = false,
        reposts = reposts,
        views = null,
        postType = "Пост",
        attachments = null,
        canDelete = true,
        canEdit = true,
    )

    println("Создание поста")
    println(service.add(post))

    val post2 = Post(
        id = vId,
        ownerId = 2,
        createdBy = 2,
        date = 1980,
        text = "Тестовый текст №2",
        replyPostId = 2,
        friendsOnly = false,
        reposts = reposts,
        views = views,
        postType = "Копия",
        attachments = null,
        canDelete = true,
        canEdit = true,
    )
    println()
    println("Обновление поста $vId")
    println(updPost(post2))
    println(post2)

    val vIdNew = 100
    val post3 = Post(
        id = vIdNew,
        ownerId = 100,
        createdBy = 100,
        date = 1986,
        text = "Тестовый текст №3",
        replyPostId = 100,
        friendsOnly = false,
        reposts = reposts,
        views = views,
        postType = "Пост",
        attachments = null,
        canDelete = true,
        canEdit = true,
    )
    println()
    println("Обновление поста $vIdNew")
    println(updPost(post3))
    println(post3)

    val comment =
        Comment(ownerId = 1, postId = 0, message = "Комментарий к посту", replyToComment = 0, stickerId = 0, guid = "")
    service.createComment(comment)
}

fun updPost(post: Post): String {
    val vId = post.id
    return if (service.update(post)) "Пост $vId обновлен успешно"
    else "Не удалось обновить пост $vId"
}