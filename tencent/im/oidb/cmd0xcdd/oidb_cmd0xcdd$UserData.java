package tencent.im.oidb.cmd0xcdd;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xcdd$UserData extends MessageMicro<oidb_cmd0xcdd$UserData> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bssid;

    /* renamed from: ip, reason: collision with root package name */
    public final PBBytesField f435990ip;
    public final PBBoolField is_nt;
    public final PBEnumField platform;
    public final PBRepeatField<Integer> port;
    public final PBBytesField ssid;

    static {
        String[] strArr = {"ip", "port", TPDownloadProxyEnum.USER_SSID, "bssid", "platform", "is_nt"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 21, 26, 34, 40, 48}, strArr, new Object[]{byteStringMicro, 0, byteStringMicro, byteStringMicro, 1, Boolean.FALSE}, oidb_cmd0xcdd$UserData.class);
    }

    public oidb_cmd0xcdd$UserData() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.f435990ip = PBField.initBytes(byteStringMicro);
        this.port = PBField.initRepeat(PBFixed32Field.__repeatHelper__);
        this.ssid = PBField.initBytes(byteStringMicro);
        this.bssid = PBField.initBytes(byteStringMicro);
        this.platform = PBField.initEnum(1);
        this.is_nt = PBField.initBool(true);
    }
}
