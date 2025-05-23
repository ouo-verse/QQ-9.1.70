package tencent.gamecenter.config;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GameCenterConfig$MobileConfQueryRsp extends MessageMicro<GameCenterConfig$MobileConfQueryRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField isPredrawHippy = PBField.initBool(false);
    public final PBBoolField isPreloadHippy = PBField.initBool(false);
    public final PBBoolField isLoadHippyInToolProcess = PBField.initBool(false);
    public final PBInt64Field loadCache = PBField.initInt64(0);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"isPredrawHippy", "isPreloadHippy", "isLoadHippyInToolProcess", "loadCache"}, new Object[]{bool, bool, bool, 0L}, GameCenterConfig$MobileConfQueryRsp.class);
    }
}
