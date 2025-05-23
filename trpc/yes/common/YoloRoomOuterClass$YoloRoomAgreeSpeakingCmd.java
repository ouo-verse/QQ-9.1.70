package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloRoomAgreeSpeakingCmd extends MessageMicro<YoloRoomOuterClass$YoloRoomAgreeSpeakingCmd> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uid", "user_id"}, new Object[]{0L, null}, YoloRoomOuterClass$YoloRoomAgreeSpeakingCmd.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
}
