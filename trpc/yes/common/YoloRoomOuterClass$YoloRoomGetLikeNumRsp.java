package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloRoomGetLikeNumRsp extends MessageMicro<YoloRoomOuterClass$YoloRoomGetLikeNumRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"list"}, new Object[]{null}, YoloRoomOuterClass$YoloRoomGetLikeNumRsp.class);
    public YoloRoomOuterClass$GameResultLikeList list = new MessageMicro<YoloRoomOuterClass$GameResultLikeList>() { // from class: trpc.yes.common.YoloRoomOuterClass$GameResultLikeList
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"list"}, new Object[]{null}, YoloRoomOuterClass$GameResultLikeList.class);
        public final PBRepeatMessageField<YoloRoomOuterClass$GameResultLikeItem> list = PBField.initRepeatMessage(YoloRoomOuterClass$GameResultLikeItem.class);
    };
}
