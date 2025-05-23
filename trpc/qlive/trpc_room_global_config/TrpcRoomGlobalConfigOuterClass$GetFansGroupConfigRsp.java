package trpc.qlive.trpc_room_global_config;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mtt.hippy.dom.node.NodeProps;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TrpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp extends MessageMicro<TrpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field retcode = PBField.initUInt32(0);
    public final PBStringField errmsg = PBField.initString("");
    public final PBBoolField fans_switch = PBField.initBool(false);
    public final PBStringField text = PBField.initString("");
    public final PBStringField btn_text = PBField.initString("");
    public final PBUInt32Field duration = PBField.initUInt32(0);
    public final PBBoolField visible = PBField.initBool(false);
    public final PBUInt32Field fans_min_level = PBField.initUInt32(0);

    static {
        String[] strArr = {"retcode", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "fans_switch", "text", "btn_text", "duration", NodeProps.VISIBLE, "fans_min_level"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 48, 56, 64}, strArr, new Object[]{0, "", bool, "", "", 0, bool, 0}, TrpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp.class);
    }
}
