package trpc.cmshow.game;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OpenGameBox$StOpenGameBoxRsp extends MessageMicro<OpenGameBox$StOpenGameBoxRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"ext", "scenes"}, new Object[]{null, null}, OpenGameBox$StOpenGameBoxRsp.class);
    public OpenGameBox$StExtend ext = new OpenGameBox$StExtend();
    public final PBRepeatMessageField<OpenGameBox$StScene> scenes = PBField.initRepeatMessage(OpenGameBox$StScene.class);
}
