package tencent.im.s2c.msgtype0x210.submsgtype0xc5;

import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0xc5$MsgBody extends MessageMicro<submsgtype0xc5$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58, 82, 90}, new String[]{"uint32_bid", "uint32_source", "operator_type", "uint64_article_id", "uint32_push_time", "uint64_seq", "str_msgid", "msg_notify_infos", "bytes_diandian_cookie"}, new Object[]{0, 0, 1, 0L, 0, 0L, "", null, ByteStringMicro.EMPTY}, submsgtype0xc5$MsgBody.class);
    public final PBUInt32Field uint32_bid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_source = PBField.initUInt32(0);
    public final PBEnumField operator_type = PBField.initEnum(1);
    public final PBUInt64Field uint64_article_id = PBField.initUInt64(0);
    public final PBUInt32Field uint32_push_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0);
    public final PBStringField str_msgid = PBField.initString("");
    public submsgtype0xc5$NotifyBody msg_notify_infos = new MessageMicro<submsgtype0xc5$NotifyBody>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5$NotifyBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 82, 90, 98, 106}, new String[]{"msg_style_sheet", "msg_comment_article", "msg_like_article", "msg_bb_info", "red_point_info"}, new Object[]{null, null, null, null, null}, submsgtype0xc5$NotifyBody.class);
        public submsgtype0xc5$StyleSheet msg_style_sheet = new MessageMicro<submsgtype0xc5$StyleSheet>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5$StyleSheet
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField bytes_orange_word;
            public final PBBytesField bytes_summary;
            public submsgtype0xc5$BiuBody msg_biu_body;
            public submsgtype0xc5$TipsBody msg_tip_body;
            public final PBEnumField msg_type;
            public final PBUInt32Field uint32_is_low;
            public final PBUInt32Field uint32_show_lock_screen;
            public final PBUInt32Field uint32_show_folder = PBField.initUInt32(0);
            public final PBEnumField folder_red_type = PBField.initEnum(0);

            static {
                String[] strArr = {"uint32_show_folder", "folder_red_type", "bytes_orange_word", "bytes_summary", "msg_tip_body", "uint32_show_lock_screen", QQHealthReportApiImpl.MSG_TYPE_KEY, "msg_biu_body", "uint32_is_low"};
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 48, 56, 66, 72}, strArr, new Object[]{0, 0, byteStringMicro, byteStringMicro, null, 0, 0, null, 0}, submsgtype0xc5$StyleSheet.class);
            }

            /* JADX WARN: Type inference failed for: r1v4, types: [tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5$TipsBody] */
            /* JADX WARN: Type inference failed for: r1v7, types: [tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5$BiuBody] */
            {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                this.bytes_orange_word = PBField.initBytes(byteStringMicro);
                this.bytes_summary = PBField.initBytes(byteStringMicro);
                this.msg_tip_body = new MessageMicro<submsgtype0xc5$TipsBody>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5$TipsBody
                    static final MessageMicro.FieldMap __fieldMap__;
                    public final PBBytesField bytes_business_info;
                    public final PBBytesField bytes_content;
                    public final PBBytesField bytes_icon_url;
                    public final PBBytesField bytes_schema;
                    public final PBEnumField tips_ui_type = PBField.initEnum(0);
                    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);

                    static {
                        String[] strArr = {"tips_ui_type", "uint64_uin", "bytes_icon_url", MessageForUniteGrayTip.KEY_BYTES_CONTENT, "bytes_schema", "bytes_business_info"};
                        ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50}, strArr, new Object[]{0, 0L, byteStringMicro2, byteStringMicro2, byteStringMicro2, byteStringMicro2}, submsgtype0xc5$TipsBody.class);
                    }

                    {
                        ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                        this.bytes_icon_url = PBField.initBytes(byteStringMicro2);
                        this.bytes_content = PBField.initBytes(byteStringMicro2);
                        this.bytes_schema = PBField.initBytes(byteStringMicro2);
                        this.bytes_business_info = PBField.initBytes(byteStringMicro2);
                    }
                };
                this.uint32_show_lock_screen = PBField.initUInt32(0);
                this.msg_type = PBField.initEnum(0);
                this.msg_biu_body = new MessageMicro<submsgtype0xc5$BiuBody>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5$BiuBody
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_biu_uin"}, new Object[]{0L}, submsgtype0xc5$BiuBody.class);
                    public final PBUInt64Field uint64_biu_uin = PBField.initUInt64(0);
                };
                this.uint32_is_low = PBField.initUInt32(0);
            }
        };
        public submsgtype0xc5$CommentInfo msg_comment_article = new MessageMicro<submsgtype0xc5$CommentInfo>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5$CommentInfo
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField bytes_comment_content;
            public final PBBytesField bytes_comment_id;
            public final PBBytesField bytes_reply_id;
            public final PBUInt64Field uint64_comment_uin = PBField.initUInt64(0);
            public final PBUInt64Field uint64_reply_uin;

            static {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{16, 26, 32, 42, 50}, new String[]{"uint64_comment_uin", "bytes_comment_id", "uint64_reply_uin", "bytes_reply_id", "bytes_comment_content"}, new Object[]{0L, byteStringMicro, 0L, byteStringMicro, byteStringMicro}, submsgtype0xc5$CommentInfo.class);
            }

            {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                this.bytes_comment_id = PBField.initBytes(byteStringMicro);
                this.uint64_reply_uin = PBField.initUInt64(0L);
                this.bytes_reply_id = PBField.initBytes(byteStringMicro);
                this.bytes_comment_content = PBField.initBytes(byteStringMicro);
            }
        };
        public submsgtype0xc5$LikeInfo msg_like_article = new MessageMicro<submsgtype0xc5$LikeInfo>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5$LikeInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{16, 24, 34}, new String[]{"uint64_like_uin", "uint32_op", "bytes_reply_id"}, new Object[]{0L, 0, ByteStringMicro.EMPTY}, submsgtype0xc5$LikeInfo.class);
            public final PBUInt64Field uint64_like_uin = PBField.initUInt64(0);
            public final PBUInt32Field uint32_op = PBField.initUInt32(0);
            public final PBBytesField bytes_reply_id = PBField.initBytes(ByteStringMicro.EMPTY);
        };
        public submsgtype0xc5$BBInfo msg_bb_info = new MessageMicro<submsgtype0xc5$BBInfo>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5$BBInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_bb_uin", "uint32_src"}, new Object[]{0L, 0}, submsgtype0xc5$BBInfo.class);
            public final PBUInt64Field uint64_bb_uin = PBField.initUInt64(0);
            public final PBUInt32Field uint32_src = PBField.initUInt32(0);
        };
        public final PBRepeatMessageField<submsgtype0xc5$RedPointInfo> red_point_info = PBField.initRepeatMessage(submsgtype0xc5$RedPointInfo.class);
    };
    public final PBBytesField bytes_diandian_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
}
