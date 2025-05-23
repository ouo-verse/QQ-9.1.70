package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vip.impl.VasQQSettingMeImpl;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class CommonOuterClass$OnlineRouteInfo extends MessageMicro<CommonOuterClass$OnlineRouteInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"route_status", VasQQSettingMeImpl.EXPIRE_TIME, "update_time", "yolo_room_route_info"}, new Object[]{0, 0, 0, null}, CommonOuterClass$OnlineRouteInfo.class);
    public final PBInt32Field route_status = PBField.initInt32(0);
    public final PBUInt32Field expire_time = PBField.initUInt32(0);
    public final PBUInt32Field update_time = PBField.initUInt32(0);
    public CommonOuterClass$RoomRouteInfo yolo_room_route_info = new CommonOuterClass$RoomRouteInfo();
}
