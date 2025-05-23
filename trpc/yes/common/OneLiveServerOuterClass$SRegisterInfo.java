package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class OneLiveServerOuterClass$SRegisterInfo extends MessageMicro<OneLiveServerOuterClass$SRegisterInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField RoomTitle = PBField.initString("");
    public final PBStringField CoverImg = PBField.initString("");
    public final PBDoubleField Longitude = PBField.initDouble(0.0d);
    public final PBDoubleField Latitude = PBField.initDouble(0.0d);

    static {
        Double valueOf = Double.valueOf(0.0d);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 25, 33}, new String[]{"RoomTitle", "CoverImg", "Longitude", "Latitude"}, new Object[]{"", "", valueOf, valueOf}, OneLiveServerOuterClass$SRegisterInfo.class);
    }
}
