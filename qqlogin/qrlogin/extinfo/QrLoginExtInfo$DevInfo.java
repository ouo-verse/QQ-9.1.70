package qqlogin.qrlogin.extinfo;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QrLoginExtInfo$DevInfo extends MessageMicro<QrLoginExtInfo$DevInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField dev_name;
    public final PBBytesField dev_type;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"dev_type", "dev_name"}, new Object[]{byteStringMicro, byteStringMicro}, QrLoginExtInfo$DevInfo.class);
    }

    public QrLoginExtInfo$DevInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.dev_type = PBField.initBytes(byteStringMicro);
        this.dev_name = PBField.initBytes(byteStringMicro);
    }
}
