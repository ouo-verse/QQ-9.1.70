package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class BaseInterfaceOuterClass$Terminal extends MessageMicro<BaseInterfaceOuterClass$Terminal> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 50}, new String[]{"imei", "imei2", TVKLiveRequestBuilder.RequestParamKey.QIMEI36, "phone_system", "platform_type", "client_version"}, new Object[]{"", "", "", 0, 1, ""}, BaseInterfaceOuterClass$Terminal.class);
    public final PBStringField imei = PBField.initString("");
    public final PBStringField imei2 = PBField.initString("");
    public final PBStringField qimei = PBField.initString("");
    public final PBEnumField phone_system = PBField.initEnum(0);
    public final PBEnumField platform_type = PBField.initEnum(1);
    public final PBStringField client_version = PBField.initString("");
}
