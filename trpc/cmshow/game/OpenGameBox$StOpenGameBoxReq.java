package trpc.cmshow.game;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OpenGameBox$StOpenGameBoxReq extends MessageMicro<OpenGameBox$StOpenGameBoxReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"ext", "scene_ids", "app_style"}, new Object[]{null, 0, 0}, OpenGameBox$StOpenGameBoxReq.class);
    public OpenGameBox$StExtend ext = new OpenGameBox$StExtend();
    public final PBRepeatField<Integer> scene_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field app_style = PBField.initUInt32(0);
}
