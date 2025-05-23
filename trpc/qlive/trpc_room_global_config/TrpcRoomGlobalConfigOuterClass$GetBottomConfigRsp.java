package trpc.qlive.trpc_room_global_config;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mtt.hippy.dom.node.NodeProps;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TrpcRoomGlobalConfigOuterClass$GetBottomConfigRsp extends MessageMicro<TrpcRoomGlobalConfigOuterClass$GetBottomConfigRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40}, new String[]{"retcode", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "outer_item", "inner_item", "version"}, new Object[]{0, "", null, null, 0}, TrpcRoomGlobalConfigOuterClass$GetBottomConfigRsp.class);
    public final PBUInt32Field retcode = PBField.initUInt32(0);
    public final PBStringField errmsg = PBField.initString("");
    public TrpcRoomGlobalConfigOuterClass$BottomItem outer_item = new MessageMicro<TrpcRoomGlobalConfigOuterClass$BottomItem>() { // from class: trpc.qlive.trpc_room_global_config.TrpcRoomGlobalConfigOuterClass$BottomItem
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 37, 40}, new String[]{"icon", "text", "url", "height", NodeProps.VISIBLE}, new Object[]{"", "", "", Float.valueOf(0.0f), Boolean.FALSE}, TrpcRoomGlobalConfigOuterClass$BottomItem.class);
        public final PBStringField icon = PBField.initString("");
        public final PBStringField text = PBField.initString("");
        public final PBStringField url = PBField.initString("");
        public final PBFloatField height = PBField.initFloat(0.0f);
        public final PBBoolField visible = PBField.initBool(false);
    };
    public final PBRepeatMessageField<TrpcRoomGlobalConfigOuterClass$BottomItem> inner_item = PBField.initRepeatMessage(TrpcRoomGlobalConfigOuterClass$BottomItem.class);
    public final PBUInt32Field version = PBField.initUInt32(0);
}
