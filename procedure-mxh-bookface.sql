DROP PROCEDURE IF EXISTS findFriend1;
DROP PROCEDURE IF EXISTS findFriend2;
DROP PROCEDURE IF EXISTS mutual_friend;

delimiter //

CREATE PROCEDURE findFriend1 (IN _userid1 INT)
BEGIN
DROP TEMPORARY TABLE IF EXISTS list_friend_1;

CREATE TEMPORARY TABLE IF NOT EXISTS list_friend_1 AS
select sender_user_id as id1 from friendship WHERE receiver_user_id = _userid1
union
select receiver_user_id from friendship WHERE sender_user_id = _userid1;
  END//

delimiter ;



delimiter //

CREATE PROCEDURE findFriend2 (IN _userid2 INT)
BEGIN
DROP TEMPORARY TABLE IF EXISTS list_friend_2;

CREATE TEMPORARY TABLE IF NOT EXISTS list_friend_2 AS
select sender_user_id as id2 from friendship WHERE receiver_user_id = _userid2
union
select receiver_user_id from friendship WHERE sender_user_id = _userid2;
  END//

delimiter ;



delimiter //
create procedure mutual_friend(in u1 int, in u2 int)
begin
call findFriend1(u1);
call findFriend2(u2);

DROP TEMPORARY TABLE IF EXISTS mutual;

CREATE TEMPORARY TABLE IF NOT EXISTS mutual AS
select * from list_friend_1 inner join list_friend_2 on list_friend_1.id1 = list_friend_2.id2;

select * from app_user where app_user.user_id in (select id1 from mutual);
end//

delimiter ;
call  findFriend1(1);
call findFriend2(4);
call mutual_friend(1,2);

delimiter //
CREATE PROCEDURE getAllChatBetweenTwoUser(IN userId1 int, IN userId2 int, IN size int)
BEGIN
    DROP TEMPORARY TABLE if exists getChatBetweenTwoUserPagination;
    create temporary table getChatBetweenTwoUserPagination
    select *
    from mxh_bookface.message
    where (receiver_user_id = userId1 and sender_user_id = userId2)
       or (receiver_user_id = userId2 and sender_user_id = userId1)
    order by message.created_time desc
    limit size offset 0;
    select * from getChatBetweenTwoUserPagination order by created_time;
END //

delimiter ;

call getAllChatBetweenTwoUser(17, 18, 1);