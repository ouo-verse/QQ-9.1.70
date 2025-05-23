package tencent.im.oidb.cmd0xeb5;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.redtouch.RedTouchWebviewHandler;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xeb5$ReqBody extends MessageMicro<oidb_0xeb5$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field friend_uin = PBField.initUInt64(0);
    public final PBUInt32Field aio_type = PBField.initUInt32(0);
    public final PBBoolField redpoint = PBField.initBool(false);
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBBytesField cookies = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBoolField no_mini_app = PBField.initBool(false);

    static {
        String[] strArr = {"friend_uin", "aio_type", RedTouchWebviewHandler.PLUGIN_NAMESPACE, WidgetCacheConstellationData.NUM, "cookies", "no_mini_app"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48}, strArr, new Object[]{0L, 0, bool, 0, ByteStringMicro.EMPTY, bool}, oidb_0xeb5$ReqBody.class);
    }
}
