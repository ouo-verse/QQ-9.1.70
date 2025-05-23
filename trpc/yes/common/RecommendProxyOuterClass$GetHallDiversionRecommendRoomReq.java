package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes30.dex */
public final class RecommendProxyOuterClass$GetHallDiversionRecommendRoomReq extends MessageMicro<RecommendProxyOuterClass$GetHallDiversionRecommendRoomReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"enter_room_req", "game_id"}, new Object[]{null, 0}, RecommendProxyOuterClass$GetHallDiversionRecommendRoomReq.class);
    public YoloRoomOuterClass$YoloRoomEnterReq enter_room_req = new YoloRoomOuterClass$YoloRoomEnterReq();
    public final PBInt32Field game_id = PBField.initInt32(0);
}
