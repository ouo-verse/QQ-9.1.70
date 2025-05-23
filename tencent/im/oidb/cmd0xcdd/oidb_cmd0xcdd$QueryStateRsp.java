package tencent.im.oidb.cmd0xcdd;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xcdd$QueryStateRsp extends MessageMicro<oidb_cmd0xcdd$QueryStateRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBEnumField biz_type;
    public final PBBytesField encrypt_key;
    public final PBEnumField state = PBField.initEnum(1);
    public final PBBytesField token;
    public oidb_cmd0xcdd$UserData user_data;

    static {
        String[] strArr = {"state", "token", "encrypt_key", QCircleScheme.AttrQQPublish.BUSINESS_USER_DATA, "biz_type"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40}, strArr, new Object[]{1, byteStringMicro, byteStringMicro, null, 1}, oidb_cmd0xcdd$QueryStateRsp.class);
    }

    public oidb_cmd0xcdd$QueryStateRsp() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.token = PBField.initBytes(byteStringMicro);
        this.encrypt_key = PBField.initBytes(byteStringMicro);
        this.user_data = new oidb_cmd0xcdd$UserData();
        this.biz_type = PBField.initEnum(1);
    }
}
