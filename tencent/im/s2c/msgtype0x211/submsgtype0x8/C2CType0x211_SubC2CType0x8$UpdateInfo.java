package tencent.im.s2c.msgtype0x211.submsgtype0x8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class C2CType0x211_SubC2CType0x8$UpdateInfo extends MessageMicro<C2CType0x211_SubC2CType0x8$UpdateInfo> {
    public static final int MSG_USER_FIELD_NUMBER = 2;
    public static final int TYPE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"type", "msg_user"}, new Object[]{1, null}, C2CType0x211_SubC2CType0x8$UpdateInfo.class);
    public final PBEnumField type = PBField.initEnum(1);
    public C2CType0x211_SubC2CType0x8$UserProfile msg_user = new MessageMicro<C2CType0x211_SubC2CType0x8$UserProfile>() { // from class: tencent.im.s2c.msgtype0x211.submsgtype0x8.C2CType0x211_SubC2CType0x8$UserProfile
        public static final int BYTES_EXTRA_FIELD_NUMBER = 11;
        public static final int BYTES_TIP_FIELD_NUMBER = 10;
        public static final int BYTES_TMP_TALK_SIG_FIELD_NUMBER = 6;
        public static final int INT32_AGE_FIELD_NUMBER = 4;
        public static final int INT32_FACE_ID_FIELD_NUMBER = 2;
        public static final int INT32_IP_FIELD_NUMBER = 8;
        public static final int INT32_PORT_FIELD_NUMBER = 9;
        public static final int INT32_SEX_FIELD_NUMBER = 3;
        public static final int MSG_RESULT_FIELD_NUMBER = 7;
        public static final int STR_NICK_FIELD_NUMBER = 5;
        public static final int UINT64_UIN_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_extra;
        public final PBBytesField bytes_tip;
        public final PBBytesField bytes_tmp_talk_sig;
        public final PBInt32Field int32_ip;
        public final PBInt32Field int32_port;
        public C2CType0x211_SubC2CType0x8$JudgeResult msg_result;
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBInt32Field int32_face_id = PBField.initInt32(0);
        public final PBInt32Field int32_sex = PBField.initInt32(0);
        public final PBInt32Field int32_age = PBField.initInt32(0);
        public final PBStringField str_nick = PBField.initString("");

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 58, 64, 72, 82, 90}, new String[]{"uint64_uin", "int32_face_id", "int32_sex", "int32_age", "str_nick", "bytes_tmp_talk_sig", "msg_result", "int32_ip", "int32_port", "bytes_tip", "bytes_extra"}, new Object[]{0L, 0, 0, 0, "", byteStringMicro, null, 0, 0, byteStringMicro, byteStringMicro}, C2CType0x211_SubC2CType0x8$UserProfile.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_tmp_talk_sig = PBField.initBytes(byteStringMicro);
            this.msg_result = new C2CType0x211_SubC2CType0x8$JudgeResult();
            this.int32_ip = PBField.initInt32(0);
            this.int32_port = PBField.initInt32(0);
            this.bytes_tip = PBField.initBytes(byteStringMicro);
            this.bytes_extra = PBField.initBytes(byteStringMicro);
        }
    };
}
