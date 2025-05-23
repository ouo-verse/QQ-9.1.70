package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.profilecard.vas.misc.VasProfileTemplatePreloadHelper;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class LiveActivityServerOuterClass$GetCurrentRoomTaskInfoRsp extends MessageMicro<LiveActivityServerOuterClass$GetCurrentRoomTaskInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"info", "rule_desc", VasProfileTemplatePreloadHelper.BACKGROUND}, new Object[]{null, "", ""}, LiveActivityServerOuterClass$GetCurrentRoomTaskInfoRsp.class);
    public LiveActivityServerOuterClass$TaskInfo info = new LiveActivityServerOuterClass$TaskInfo();
    public final PBStringField rule_desc = PBField.initString("");

    /* renamed from: bg, reason: collision with root package name */
    public final PBStringField f437242bg = PBField.initString("");
}
