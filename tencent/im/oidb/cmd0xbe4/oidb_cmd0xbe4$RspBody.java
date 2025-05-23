package tencent.im.oidb.cmd0xbe4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xbe4$RspBody extends MessageMicro<oidb_cmd0xbe4$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_get_rsp"}, new Object[]{null}, oidb_cmd0xbe4$RspBody.class);
    public oidb_cmd0xbe4$MsgGetRsp msg_get_rsp = new MessageMicro<oidb_cmd0xbe4$MsgGetRsp>() { // from class: tencent.im.oidb.cmd0xbe4.oidb_cmd0xbe4$MsgGetRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint64_unread", "uint64_max_seq", "msg_body"}, new Object[]{0L, 0L, null}, oidb_cmd0xbe4$MsgGetRsp.class);
        public final PBUInt64Field uint64_unread = PBField.initUInt64(0);
        public final PBUInt64Field uint64_max_seq = PBField.initUInt64(0);
        public oidb_cmd0xbe4$MsgBody msg_body = new MessageMicro<oidb_cmd0xbe4$MsgBody>() { // from class: tencent.im.oidb.cmd0xbe4.oidb_cmd0xbe4$MsgBody
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField bytes_ext_data;
            public final PBBytesField bytes_jump_url;
            public final PBBytesField bytes_pic_url;
            public oidb_cmd0xbe4$MsgContent msg_content;
            public oidb_cmd0xbe4$MsgFolderInfo msg_folder_info;
            public final PBStringField str_msgid;
            public final PBStringField str_summary;
            public final PBUInt32Field uint32_msg_sub_type;
            public final PBUInt64Field uint64_seq = PBField.initUInt64(0);
            public final PBUInt64Field uint64_msg_time = PBField.initUInt64(0);
            public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
            public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);

            static {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 58, 66, 74, 82, 88, 106}, new String[]{"uint64_seq", "uint64_msg_time", "uint32_msg_type", "uint64_from_uin", "bytes_pic_url", "bytes_jump_url", "msg_folder_info", "msg_content", "bytes_ext_data", "str_msgid", "uint32_msg_sub_type", "str_summary"}, new Object[]{0L, 0L, 0, 0L, byteStringMicro, byteStringMicro, null, null, byteStringMicro, "", 0, ""}, oidb_cmd0xbe4$MsgBody.class);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [tencent.im.oidb.cmd0xbe4.oidb_cmd0xbe4$MsgFolderInfo] */
            /* JADX WARN: Type inference failed for: r1v3, types: [tencent.im.oidb.cmd0xbe4.oidb_cmd0xbe4$MsgContent] */
            {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                this.bytes_pic_url = PBField.initBytes(byteStringMicro);
                this.bytes_jump_url = PBField.initBytes(byteStringMicro);
                this.msg_folder_info = new MessageMicro<oidb_cmd0xbe4$MsgFolderInfo>() { // from class: tencent.im.oidb.cmd0xbe4.oidb_cmd0xbe4$MsgFolderInfo
                    static final MessageMicro.FieldMap __fieldMap__;
                    public final PBBytesField bytes_orange_word;
                    public final PBBytesField bytes_summary;
                    public final PBUInt32Field uint32_show_folder = PBField.initUInt32(0);
                    public final PBUInt32Field folder_red_type = PBField.initUInt32(0);

                    static {
                        ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"uint32_show_folder", "folder_red_type", "bytes_orange_word", "bytes_summary"}, new Object[]{0, 0, byteStringMicro2, byteStringMicro2}, oidb_cmd0xbe4$MsgFolderInfo.class);
                    }

                    {
                        ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                        this.bytes_orange_word = PBField.initBytes(byteStringMicro2);
                        this.bytes_summary = PBField.initBytes(byteStringMicro2);
                    }
                };
                this.msg_content = new MessageMicro<oidb_cmd0xbe4$MsgContent>() { // from class: tencent.im.oidb.cmd0xbe4.oidb_cmd0xbe4$MsgContent
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 90, 98, 106, 112}, new String[]{"string_feeds_id", "uint32_feed_type", "uint32_type", "str_desc", "str_feeds_pic", "string_sys_activityid", "uint32_sys_from"}, new Object[]{"", 0, 0, "", "", "", 0}, oidb_cmd0xbe4$MsgContent.class);
                    public final PBStringField string_feeds_id = PBField.initString("");
                    public final PBUInt32Field uint32_feed_type = PBField.initUInt32(0);
                    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
                    public final PBStringField str_desc = PBField.initString("");
                    public final PBStringField str_feeds_pic = PBField.initString("");
                    public final PBStringField string_sys_activityid = PBField.initString("");
                    public final PBUInt32Field uint32_sys_from = PBField.initUInt32(0);
                };
                this.bytes_ext_data = PBField.initBytes(byteStringMicro);
                this.str_msgid = PBField.initString("");
                this.uint32_msg_sub_type = PBField.initUInt32(0);
                this.str_summary = PBField.initString("");
            }
        };
    };
}
