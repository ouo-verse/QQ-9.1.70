package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_msg_body$SecretFileMsg extends MessageMicro<im_msg_body$SecretFileMsg> {
    public static final int TYPE_C2C = 0;
    public static final int TYPE_DISCU = 4;
    public static final int TYPE_GROUP = 2;
    public static final int TYPE_NEARBA = 3;
    public static final int TYPE_WPA = 5;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_encrypt_key;
    public final PBBytesField bytes_file_key;
    public im_msg_body$ElemFlags2 elem_flags2;
    public im_msg_body$NotOnlineImage not_online_image;
    public final PBStringField str_fromphonenum;
    public final PBUInt32Field uint32_encrypt_prehead_length;
    public final PBUInt32Field uint32_encrypt_type;
    public final PBUInt32Field uint32_left_time;
    public final PBUInt32Field uint32_opertype;
    public final PBUInt32Field uint32_read_times;
    public final PBUInt32Field uint32_status;
    public final PBUInt32Field uint32_ttl;
    public final PBUInt32Field uint32_type;
    public final PBUInt64Field uint64_from_uin;
    public final PBUInt64Field uint64_to_uin;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 56, 64, 74, 80, 88, 98, 106, 112, 122}, new String[]{"bytes_file_key", "uint64_from_uin", "uint64_to_uin", "uint32_status", "uint32_ttl", "uint32_type", "uint32_encrypt_prehead_length", "uint32_encrypt_type", "bytes_encrypt_key", "uint32_read_times", "uint32_left_time", "not_online_image", "elem_flags2", "uint32_opertype", "str_fromphonenum"}, new Object[]{byteStringMicro, 0L, 0L, 0, 0, 0, 0, 0, byteStringMicro, 0, 0, null, null, 0, ""}, im_msg_body$SecretFileMsg.class);
    }

    public im_msg_body$SecretFileMsg() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_file_key = PBField.initBytes(byteStringMicro);
        this.uint64_from_uin = PBField.initUInt64(0L);
        this.uint64_to_uin = PBField.initUInt64(0L);
        this.uint32_status = PBField.initUInt32(0);
        this.uint32_ttl = PBField.initUInt32(0);
        this.uint32_type = PBField.initUInt32(0);
        this.uint32_encrypt_prehead_length = PBField.initUInt32(0);
        this.uint32_encrypt_type = PBField.initUInt32(0);
        this.bytes_encrypt_key = PBField.initBytes(byteStringMicro);
        this.uint32_read_times = PBField.initUInt32(0);
        this.uint32_left_time = PBField.initUInt32(0);
        this.not_online_image = new im_msg_body$NotOnlineImage();
        this.elem_flags2 = new im_msg_body$ElemFlags2();
        this.uint32_opertype = PBField.initUInt32(0);
        this.str_fromphonenum = PBField.initString("");
    }
}
