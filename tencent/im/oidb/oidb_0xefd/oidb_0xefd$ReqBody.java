package tencent.im.oidb.oidb_0xefd;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xefd$ReqBody extends MessageMicro<oidb_0xefd$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82}, new String[]{"sub_comment_create_req", "sub_comment_delete_req", "sub_comment_strike_req", "first_comment_create_req", "first_comment_delete_req", "first_comment_strike_req", "first_comment_like_set_req", "sub_comment_like_set_req", "author_comment_delete_req", "first_comment_author_top_set_req"}, new Object[]{null, null, null, null, null, null, null, null, null, null}, oidb_0xefd$ReqBody.class);
    public oidb_0xefd$SubCommentCreateReq sub_comment_create_req = new MessageMicro<oidb_0xefd$SubCommentCreateReq>() { // from class: tencent.im.oidb.oidb_0xefd.oidb_0xefd$SubCommentCreateReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 50, 58, 64, 72, 80, 90, 96, 106, 114, 120, 130, 136, 144, 152, 162, 170, 184, 194, 200, 208, 810}, new String[]{AppConstants.Key.SHARE_REQ_ARTICLE_ID, "first_comment_id", "author_id", "src_author_id", "replied_sub_author_id", "replied_sub_comment_id", "content", "is_anonymous", "content_src", "src", "business_info", AlbumCacheData.CREATE_TIME, "media_data", "user_info", "is_multi_media", "rpt_media_data_list", "hide_name", "src_uin", "shared_uin", "rowkey", "rpt_data", "scene", "link_data", "detect_dirty_word", QCircleScheme.AttrQQPublish.NEED_USER_INFO, "extra_param"}, new Object[]{"", "", 0L, 0L, 0L, "", "", 0, 0, 0, "", 0L, null, null, 0, null, 0, 0L, 0, "", null, 0, null, 0, 0, ""}, oidb_0xefd$SubCommentCreateReq.class);
        public final PBStringField article_id = PBField.initString("");
        public final PBStringField first_comment_id = PBField.initString("");
        public final PBUInt64Field author_id = PBField.initUInt64(0);
        public final PBUInt64Field src_author_id = PBField.initUInt64(0);
        public final PBUInt64Field replied_sub_author_id = PBField.initUInt64(0);
        public final PBStringField replied_sub_comment_id = PBField.initString("");
        public final PBStringField content = PBField.initString("");
        public final PBUInt32Field is_anonymous = PBField.initUInt32(0);
        public final PBUInt32Field content_src = PBField.initUInt32(0);
        public final PBUInt32Field src = PBField.initUInt32(0);
        public final PBStringField business_info = PBField.initString("");
        public final PBInt64Field create_time = PBField.initInt64(0);
        public oidb_0xefd$MediaData media_data = new oidb_0xefd$MediaData();
        public oidb_0xefd$UserInfo user_info = new oidb_0xefd$UserInfo();
        public final PBUInt32Field is_multi_media = PBField.initUInt32(0);
        public final PBRepeatMessageField<oidb_0xefd$MediaData> rpt_media_data_list = PBField.initRepeatMessage(oidb_0xefd$MediaData.class);
        public final PBInt32Field hide_name = PBField.initInt32(0);
        public final PBUInt64Field src_uin = PBField.initUInt64(0);
        public final PBUInt32Field shared_uin = PBField.initUInt32(0);
        public final PBStringField rowkey = PBField.initString("");
        public final PBRepeatMessageField<oidb_0xefd$RptData> rpt_data = PBField.initRepeatMessage(oidb_0xefd$RptData.class);
        public final PBUInt32Field scene = PBField.initUInt32(0);
        public final PBRepeatMessageField<oidb_0xefd$LinkData> link_data = PBField.initRepeatMessage(oidb_0xefd$LinkData.class);
        public final PBUInt32Field detect_dirty_word = PBField.initUInt32(0);
        public final PBUInt32Field need_user_info = PBField.initUInt32(0);
        public final PBStringField extra_param = PBField.initString("");
    };
    public oidb_0xefd$SubCommentDeleteReq sub_comment_delete_req = new MessageMicro<oidb_0xefd$SubCommentDeleteReq>() { // from class: tencent.im.oidb.oidb_0xefd.oidb_0xefd$SubCommentDeleteReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 48, 56, 66}, new String[]{AppConstants.Key.SHARE_REQ_ARTICLE_ID, "first_comment_id", "sub_comment_id", "author_id", "content_src", "src", "shared_uin", "business_info"}, new Object[]{"", "", "", 0L, 0, 0, 0, ""}, oidb_0xefd$SubCommentDeleteReq.class);
        public final PBStringField article_id = PBField.initString("");
        public final PBStringField first_comment_id = PBField.initString("");
        public final PBStringField sub_comment_id = PBField.initString("");
        public final PBUInt64Field author_id = PBField.initUInt64(0);
        public final PBUInt32Field content_src = PBField.initUInt32(0);
        public final PBUInt32Field src = PBField.initUInt32(0);
        public final PBUInt32Field shared_uin = PBField.initUInt32(0);
        public final PBStringField business_info = PBField.initString("");
    };
    public oidb_0xefd$SubCommentStrikeReq sub_comment_strike_req = new MessageMicro<oidb_0xefd$SubCommentStrikeReq>() { // from class: tencent.im.oidb.oidb_0xefd.oidb_0xefd$SubCommentStrikeReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 48, 56}, new String[]{AppConstants.Key.SHARE_REQ_ARTICLE_ID, "first_comment_id", "sub_comment_id", "author_id", "src", "op"}, new Object[]{"", "", "", 0L, 0, 0}, oidb_0xefd$SubCommentStrikeReq.class);
        public final PBStringField article_id = PBField.initString("");
        public final PBStringField first_comment_id = PBField.initString("");
        public final PBStringField sub_comment_id = PBField.initString("");
        public final PBUInt64Field author_id = PBField.initUInt64(0);
        public final PBUInt32Field src = PBField.initUInt32(0);

        /* renamed from: op, reason: collision with root package name */
        public final PBUInt32Field f436019op = PBField.initUInt32(0);
    };
    public oidb_0xefd$FirstCommentCreateReq first_comment_create_req = new MessageMicro<oidb_0xefd$FirstCommentCreateReq>() { // from class: tencent.im.oidb.oidb_0xefd.oidb_0xefd$FirstCommentCreateReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40, 50, 56, 64, 74, 80, 88, 98, 106, 112, 120, 130, 138, 152, 162, 168, 176, 810}, new String[]{AppConstants.Key.SHARE_REQ_ARTICLE_ID, "author_id", IPublicAccountBrowser.KEY_PUB_UIN, "content", "is_anonymous", "business_info", AlbumCacheData.CREATE_TIME, "is_multi_media", "media_data", "content_src", "src", "user_info", "rpt_media_data_list", "hide_name", "src_uin", "rowkey", "rpt_data", "scene", "link_data", "detect_dirty_word", QCircleScheme.AttrQQPublish.NEED_USER_INFO, "extra_param"}, new Object[]{"", 0L, 0L, "", 0, "", 0L, 0, null, 0, 0, null, null, 0, 0L, "", null, 0, null, 0, 0, ""}, oidb_0xefd$FirstCommentCreateReq.class);
        public final PBStringField article_id = PBField.initString("");
        public final PBUInt64Field author_id = PBField.initUInt64(0);
        public final PBUInt64Field puin = PBField.initUInt64(0);
        public final PBStringField content = PBField.initString("");
        public final PBInt32Field is_anonymous = PBField.initInt32(0);
        public final PBStringField business_info = PBField.initString("");
        public final PBInt64Field create_time = PBField.initInt64(0);
        public final PBUInt32Field is_multi_media = PBField.initUInt32(0);
        public oidb_0xefd$MediaData media_data = new oidb_0xefd$MediaData();
        public final PBUInt32Field content_src = PBField.initUInt32(0);
        public final PBUInt32Field src = PBField.initUInt32(0);
        public oidb_0xefd$UserInfo user_info = new oidb_0xefd$UserInfo();
        public final PBRepeatMessageField<oidb_0xefd$MediaData> rpt_media_data_list = PBField.initRepeatMessage(oidb_0xefd$MediaData.class);
        public final PBInt32Field hide_name = PBField.initInt32(0);
        public final PBUInt64Field src_uin = PBField.initUInt64(0);
        public final PBStringField rowkey = PBField.initString("");
        public final PBRepeatMessageField<oidb_0xefd$RptData> rpt_data = PBField.initRepeatMessage(oidb_0xefd$RptData.class);
        public final PBUInt32Field scene = PBField.initUInt32(0);
        public final PBRepeatMessageField<oidb_0xefd$LinkData> link_data = PBField.initRepeatMessage(oidb_0xefd$LinkData.class);
        public final PBUInt32Field detect_dirty_word = PBField.initUInt32(0);
        public final PBUInt32Field need_user_info = PBField.initUInt32(0);
        public final PBStringField extra_param = PBField.initString("");
    };
    public oidb_0xefd$FirstCommentDeleteReq first_comment_delete_req = new MessageMicro<oidb_0xefd$FirstCommentDeleteReq>() { // from class: tencent.im.oidb.oidb_0xefd.oidb_0xefd$FirstCommentDeleteReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 58}, new String[]{AppConstants.Key.SHARE_REQ_ARTICLE_ID, "comment_id", "author_id", "content_src", "src", "shared_uin", "business_info"}, new Object[]{"", "", 0L, 0, 0, 0, ""}, oidb_0xefd$FirstCommentDeleteReq.class);
        public final PBStringField article_id = PBField.initString("");
        public final PBStringField comment_id = PBField.initString("");
        public final PBUInt64Field author_id = PBField.initUInt64(0);
        public final PBInt32Field content_src = PBField.initInt32(0);
        public final PBUInt32Field src = PBField.initUInt32(0);
        public final PBUInt32Field shared_uin = PBField.initUInt32(0);
        public final PBStringField business_info = PBField.initString("");
    };
    public oidb_0xefd$FirstCommentStrikeReq first_comment_strike_req = new MessageMicro<oidb_0xefd$FirstCommentStrikeReq>() { // from class: tencent.im.oidb.oidb_0xefd.oidb_0xefd$FirstCommentStrikeReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 48, 56, 64}, new String[]{AppConstants.Key.SHARE_REQ_ARTICLE_ID, "comment_id", "author_id", "op", "msg", "op_id", "src", "shared_uin"}, new Object[]{"", "", 0L, 0, "", 0, 0, 0}, oidb_0xefd$FirstCommentStrikeReq.class);
        public final PBStringField article_id = PBField.initString("");
        public final PBStringField comment_id = PBField.initString("");
        public final PBUInt64Field author_id = PBField.initUInt64(0);

        /* renamed from: op, reason: collision with root package name */
        public final PBUInt32Field f436018op = PBField.initUInt32(0);

        /* renamed from: msg, reason: collision with root package name */
        public final PBStringField f436017msg = PBField.initString("");
        public final PBInt32Field op_id = PBField.initInt32(0);
        public final PBUInt32Field src = PBField.initUInt32(0);
        public final PBUInt32Field shared_uin = PBField.initUInt32(0);
    };
    public oidb_0xefd$FirstCommentLikeSetReq first_comment_like_set_req = new MessageMicro<oidb_0xefd$FirstCommentLikeSetReq>() { // from class: tencent.im.oidb.oidb_0xefd.oidb_0xefd$FirstCommentLikeSetReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 56, 64, 74}, new String[]{AppConstants.Key.SHARE_REQ_ARTICLE_ID, "comment_id", "author_id", "like", "op_type", "content_src", "pin", "src", "business_info"}, new Object[]{"", "", 0L, 0, 0, 0, 0, 0, ""}, oidb_0xefd$FirstCommentLikeSetReq.class);
        public final PBStringField article_id = PBField.initString("");
        public final PBStringField comment_id = PBField.initString("");
        public final PBUInt64Field author_id = PBField.initUInt64(0);
        public final PBUInt32Field like = PBField.initUInt32(0);
        public final PBUInt32Field op_type = PBField.initUInt32(0);
        public final PBUInt32Field content_src = PBField.initUInt32(0);
        public final PBUInt32Field pin = PBField.initUInt32(0);
        public final PBUInt32Field src = PBField.initUInt32(0);
        public final PBStringField business_info = PBField.initString("");
    };
    public oidb_0xefd$SubCommentLikeSetReq sub_comment_like_set_req = new MessageMicro<oidb_0xefd$SubCommentLikeSetReq>() { // from class: tencent.im.oidb.oidb_0xefd.oidb_0xefd$SubCommentLikeSetReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 56, 64, 72, 82}, new String[]{AppConstants.Key.SHARE_REQ_ARTICLE_ID, "first_comment_id", "author_id", "sub_id", "like", "op_type", "content_src", "pin", "src", "business_info"}, new Object[]{"", "", 0L, 0, 0, 0, 0, 0, 0, ""}, oidb_0xefd$SubCommentLikeSetReq.class);
        public final PBStringField article_id = PBField.initString("");
        public final PBStringField first_comment_id = PBField.initString("");
        public final PBUInt64Field author_id = PBField.initUInt64(0);
        public final PBUInt32Field sub_id = PBField.initUInt32(0);
        public final PBUInt32Field like = PBField.initUInt32(0);
        public final PBUInt32Field op_type = PBField.initUInt32(0);
        public final PBUInt32Field content_src = PBField.initUInt32(0);
        public final PBUInt32Field pin = PBField.initUInt32(0);
        public final PBUInt32Field src = PBField.initUInt32(0);
        public final PBStringField business_info = PBField.initString("");
    };
    public oidb_0xefd$AuthorCommentDeleteReq author_comment_delete_req = new MessageMicro<oidb_0xefd$AuthorCommentDeleteReq>() { // from class: tencent.im.oidb.oidb_0xefd.oidb_0xefd$AuthorCommentDeleteReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 48, 58}, new String[]{AppConstants.Key.SHARE_REQ_ARTICLE_ID, "first_comment_id", "sub_comment_id", "comment_type", "content_src", "src", "business_info"}, new Object[]{"", "", "", 0, 0, 0, ""}, oidb_0xefd$AuthorCommentDeleteReq.class);
        public final PBStringField article_id = PBField.initString("");
        public final PBStringField first_comment_id = PBField.initString("");
        public final PBStringField sub_comment_id = PBField.initString("");
        public final PBUInt32Field comment_type = PBField.initUInt32(0);
        public final PBUInt32Field content_src = PBField.initUInt32(0);
        public final PBUInt32Field src = PBField.initUInt32(0);
        public final PBStringField business_info = PBField.initString("");
    };
    public oidb_0xefd$FirstCommentAuthorTopSetReq first_comment_author_top_set_req = new MessageMicro<oidb_0xefd$FirstCommentAuthorTopSetReq>() { // from class: tencent.im.oidb.oidb_0xefd.oidb_0xefd$FirstCommentAuthorTopSetReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 58}, new String[]{AppConstants.Key.SHARE_REQ_ARTICLE_ID, "comment_id", "comment_type", "op_type", "content_src", "src", "business_info"}, new Object[]{"", "", 0, 0, 0, 0, ""}, oidb_0xefd$FirstCommentAuthorTopSetReq.class);
        public final PBStringField article_id = PBField.initString("");
        public final PBStringField comment_id = PBField.initString("");
        public final PBUInt32Field comment_type = PBField.initUInt32(0);
        public final PBUInt32Field op_type = PBField.initUInt32(0);
        public final PBUInt32Field content_src = PBField.initUInt32(0);
        public final PBUInt32Field src = PBField.initUInt32(0);
        public final PBStringField business_info = PBField.initString("");
    };
}
