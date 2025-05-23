package tencent.im.msg;

import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_msg_body$Text extends MessageMicro<im_msg_body$Text> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField attr_6_buf;
    public final PBBytesField attr_7_buf;
    public final PBBytesField buf;
    public final PBBytesField bytes_pb_reserve;
    public final PBStringField link;
    public final PBBytesField str;

    static {
        String[] strArr = {"str", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "attr_6_buf", "attr_7_buf", "buf", "bytes_pb_reserve"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 90, 98}, strArr, new Object[]{byteStringMicro, "", byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, im_msg_body$Text.class);
    }

    public im_msg_body$Text() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.str = PBField.initBytes(byteStringMicro);
        this.link = PBField.initString("");
        this.attr_6_buf = PBField.initBytes(byteStringMicro);
        this.attr_7_buf = PBField.initBytes(byteStringMicro);
        this.buf = PBField.initBytes(byteStringMicro);
        this.bytes_pb_reserve = PBField.initBytes(byteStringMicro);
    }
}
