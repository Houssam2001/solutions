SELECT DISTINCT a.author_id AS id
FROM Views AS a
JOIN Views AS b ON a.author_id = b.viewer_id AND a.article_id = b.article_id
WHERE a.author_id = b.author_id
ORDER BY id ASC;
