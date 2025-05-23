package tencent.im.oidb.oidb_0xefd;

import com.tencent.luggage.wxa.uf.n;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xefd$RspBody extends MessageMicro<oidb_0xefd$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"retmsg", "retcode", "result"}, new Object[]{"", 0, null}, oidb_0xefd$RspBody.class);
    public final PBStringField retmsg = PBField.initString("");
    public final PBInt32Field retcode = PBField.initInt32(0);
    public oidb_0xefd$RspResult result = new MessageMicro<oidb_0xefd$RspResult>() { // from class: tencent.im.oidb.oidb_0xefd.oidb_0xefd$RspResult
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82}, new String[]{"sub_comment_create_rsp", "sub_comment_delete_rsp", "sub_comment_strike_rsp", "first_comment_create_rsp", "first_comment_delete_rsp", "first_comment_strike_rsp", "first_comment_like_set_rsp", "sub_comment_like_set_rsp", "author_comment_delete_rsp", "first_comment_author_top_set_rsp"}, new Object[]{null, null, null, null, null, null, null, null, null, null}, oidb_0xefd$RspResult.class);
        public oidb_0xefd$SubCommentCreateRsp sub_comment_create_rsp = new MessageMicro<oidb_0xefd$SubCommentCreateRsp>() { // from class: tencent.im.oidb.oidb_0xefd.oidb_0xefd$SubCommentCreateRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, n.CTRL_INDEX, 818}, new String[]{"sub_comment_id", "link_comment_over_times", "link_comment_num", "dirty_word_show_toast", "str_comment", "str_user_info"}, new Object[]{0, 0, 0, 0, "", ""}, oidb_0xefd$SubCommentCreateRsp.class);
            public final PBInt32Field sub_comment_id = PBField.initInt32(0);
            public final PBUInt32Field link_comment_over_times = PBField.initUInt32(0);
            public final PBStringField str_comment = PBField.initString("");
            public final PBUInt32Field link_comment_num = PBField.initUInt32(0);
            public final PBUInt32Field dirty_word_show_toast = PBField.initUInt32(0);
            public final PBStringField str_user_info = PBField.initString("");
        };
        public oidb_0xefd$SubCommentDeleteRsp sub_comment_delete_rsp = new MessageMicro<oidb_0xefd$SubCommentDeleteRsp>() { // from class: tencent.im.oidb.oidb_0xefd.oidb_0xefd$SubCommentDeleteRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_0xefd$SubCommentDeleteRsp.class);
        };
        public oidb_0xefd$SubCommentStrikeRsp sub_comment_strike_rsp = new MessageMicro<oidb_0xefd$SubCommentStrikeRsp>() { // from class: tencent.im.oidb.oidb_0xefd.oidb_0xefd$SubCommentStrikeRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_0xefd$SubCommentStrikeRsp.class);
        };
        public oidb_0xefd$FirstCommentCreateRsp first_comment_create_rsp = new MessageMicro<oidb_0xefd$FirstCommentCreateRsp>() { // from class: tencent.im.oidb.oidb_0xefd.oidb_0xefd$FirstCommentCreateRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, n.CTRL_INDEX, 818}, new String[]{"comment_id", "link_comment_over_times", "link_comment_num", "dirty_word_show_toast", "str_comment", "str_user_info"}, new Object[]{"", 0, 0, 0, "", ""}, oidb_0xefd$FirstCommentCreateRsp.class);
            public final PBStringField comment_id = PBField.initString("");
            public final PBUInt32Field link_comment_over_times = PBField.initUInt32(0);
            public final PBStringField str_comment = PBField.initString("");
            public final PBUInt32Field link_comment_num = PBField.initUInt32(0);
            public final PBUInt32Field dirty_word_show_toast = PBField.initUInt32(0);
            public final PBStringField str_user_info = PBField.initString("");
        };
        public oidb_0xefd$FirstCommentDeleteRsp first_comment_delete_rsp = new MessageMicro<oidb_0xefd$FirstCommentDeleteRsp>() { // from class: tencent.im.oidb.oidb_0xefd.oidb_0xefd$FirstCommentDeleteRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_0xefd$FirstCommentDeleteRsp.class);
        };
        public oidb_0xefd$FirstCommentStrikeRsp first_comment_strike_rsp = new MessageMicro<oidb_0xefd$FirstCommentStrikeRsp>() { // from class: tencent.im.oidb.oidb_0xefd.oidb_0xefd$FirstCommentStrikeRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_0xefd$FirstCommentStrikeRsp.class);
        };
        public oidb_0xefd$FirstCommentLikeSetRsp first_comment_like_set_rsp = new MessageMicro<oidb_0xefd$FirstCommentLikeSetRsp>() { // from class: tencent.im.oidb.oidb_0xefd.oidb_0xefd$FirstCommentLikeSetRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_0xefd$FirstCommentLikeSetRsp.class);
        };
        public oidb_0xefd$SubCommentLikeSetRsp sub_comment_like_set_rsp = new MessageMicro<oidb_0xefd$SubCommentLikeSetRsp>() { // from class: tencent.im.oidb.oidb_0xefd.oidb_0xefd$SubCommentLikeSetRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_0xefd$SubCommentLikeSetRsp.class);
        };
        public oidb_0xefd$AuthorCommentDeleteRsp author_comment_delete_rsp = new MessageMicro<oidb_0xefd$AuthorCommentDeleteRsp>() { // from class: tencent.im.oidb.oidb_0xefd.oidb_0xefd$AuthorCommentDeleteRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"over_times"}, new Object[]{0}, oidb_0xefd$AuthorCommentDeleteRsp.class);
            public final PBUInt32Field over_times = PBField.initUInt32(0);
        };
        public oidb_0xefd$FirstCommentAuthorTopSetRsp first_comment_author_top_set_rsp = new MessageMicro<oidb_0xefd$FirstCommentAuthorTopSetRsp>() { // from class: tencent.im.oidb.oidb_0xefd.oidb_0xefd$FirstCommentAuthorTopSetRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"over_times"}, new Object[]{0}, oidb_0xefd$FirstCommentAuthorTopSetRsp.class);
            public final PBUInt32Field over_times = PBField.initUInt32(0);
        };
    };
}
