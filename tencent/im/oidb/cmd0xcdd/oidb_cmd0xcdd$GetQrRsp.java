package tencent.im.oidb.cmd0xcdd;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xcdd$GetQrRsp extends MessageMicro<oidb_cmd0xcdd$GetQrRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBEnumField biz_type;
    public final PBBytesField encrypt_key;
    public final PBBytesField qr_sig;
    public final PBBytesField token;
    public oidb_cmd0xcdd$UserData user_data;

    static {
        String[] strArr = {"qr_sig", "token", "encrypt_key", QCircleScheme.AttrQQPublish.BUSINESS_USER_DATA, "biz_type"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40}, strArr, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, null, 1}, oidb_cmd0xcdd$GetQrRsp.class);
    }

    public oidb_cmd0xcdd$GetQrRsp() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.qr_sig = PBField.initBytes(byteStringMicro);
        this.token = PBField.initBytes(byteStringMicro);
        this.encrypt_key = PBField.initBytes(byteStringMicro);
        this.user_data = new oidb_cmd0xcdd$UserData();
        this.biz_type = PBField.initEnum(1);
    }
}
