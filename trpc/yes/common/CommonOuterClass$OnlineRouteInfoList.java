package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class CommonOuterClass$OnlineRouteInfoList extends MessageMicro<CommonOuterClass$OnlineRouteInfoList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"route_list"}, new Object[]{null}, CommonOuterClass$OnlineRouteInfoList.class);
    public final PBRepeatMessageField<CommonOuterClass$OnlineRouteInfo> route_list = PBField.initRepeatMessage(CommonOuterClass$OnlineRouteInfo.class);

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class TestInner extends MessageMicro<TestInner> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"aaa"}, new Object[]{0}, TestInner.class);
        public final PBInt32Field aaa = PBField.initInt32(0);
    }
}
