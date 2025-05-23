package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloRoomReadyStatusChangeCmd extends MessageMicro<YoloRoomOuterClass$YoloRoomReadyStatusChangeCmd> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"op"}, new Object[]{0}, YoloRoomOuterClass$YoloRoomReadyStatusChangeCmd.class);

    /* renamed from: op, reason: collision with root package name */
    public final PBInt32Field f437260op = PBField.initInt32(0);
}
