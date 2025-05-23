package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes30.dex */
public final class RecommendProxyOuterClass$GetHallDiversionRecommendRoomRsp extends MessageMicro<RecommendProxyOuterClass$GetHallDiversionRecommendRoomRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"enter_room_rsp", "white_flag", "room_list"}, new Object[]{null, 0, null}, RecommendProxyOuterClass$GetHallDiversionRecommendRoomRsp.class);
    public YoloRoomOuterClass$YoloRoomEnterRsp enter_room_rsp = new YoloRoomOuterClass$YoloRoomEnterRsp();
    public final PBInt32Field white_flag = PBField.initInt32(0);
    public final PBRepeatMessageField<RecommendProxyOuterClass$KuolieRoomInfo> room_list = PBField.initRepeatMessage(RecommendProxyOuterClass$KuolieRoomInfo.class);
}
