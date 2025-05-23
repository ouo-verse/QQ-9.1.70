package qqlogin.qrlogin.extinfo;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QrLoginExtInfo$ScanExtInfo extends MessageMicro<QrLoginExtInfo$ScanExtInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField allow_auto_renew_ticket;
    public final PBBytesField guid;
    public final PBBytesField imei;
    public final PBBoolField invalid_gen_ticket;
    public final PBEnumField scan_scene;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40}, new String[]{"guid", "imei", "scan_scene", "allow_auto_renew_ticket", "invalid_gen_ticket"}, new Object[]{byteStringMicro, byteStringMicro, 0, bool, bool}, QrLoginExtInfo$ScanExtInfo.class);
    }

    public QrLoginExtInfo$ScanExtInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.guid = PBField.initBytes(byteStringMicro);
        this.imei = PBField.initBytes(byteStringMicro);
        this.scan_scene = PBField.initEnum(0);
        this.allow_auto_renew_ticket = PBField.initBool(false);
        this.invalid_gen_ticket = PBField.initBool(false);
    }
}
