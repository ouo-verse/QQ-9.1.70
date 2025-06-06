package tencent.im.s2c.msgtype0x210.submsgtype0x4e;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Submsgtype0x4e$MsgBody extends MessageMicro<Submsgtype0x4e$MsgBody> {
    public static final int MSG_GROUP_BULLETIN_FIELD_NUMBER = 4;
    public static final int UINT32_APPID_FIELD_NUMBER = 3;
    public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 2;
    public static final int UINT64_GROUP_ID_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"uint64_group_id", "uint64_group_code", "uint32_appid", "msg_group_bulletin"}, new Object[]{0L, 0L, 0, null}, Submsgtype0x4e$MsgBody.class);
    public final PBUInt64Field uint64_group_id = PBField.initUInt64(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public Submsgtype0x4e$GroupBulletin msg_group_bulletin = new MessageMicro<Submsgtype0x4e$GroupBulletin>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x4e.Submsgtype0x4e$GroupBulletin
        public static final int RPT_MSG_CONTENT_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_content"}, new Object[]{null}, Submsgtype0x4e$GroupBulletin.class);
        public final PBRepeatMessageField<Content> rpt_msg_content = PBField.initRepeatMessage(Content.class);

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class Content extends MessageMicro<Content> {
            public static final int BYTES_FEEDID_FIELD_NUMBER = 1;
            public static final int UINT32_TIME_FIELD_NUMBER = 3;
            public static final int UINT64_UIN_FIELD_NUMBER = 2;
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 29}, new String[]{"bytes_feedid", "uint64_uin", "uint32_time"}, new Object[]{ByteStringMicro.EMPTY, 0L, 0}, Content.class);
            public final PBBytesField bytes_feedid = PBField.initBytes(ByteStringMicro.EMPTY);
            public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
            public final PBFixed32Field uint32_time = PBField.initFixed32(0);
        }
    };
}
