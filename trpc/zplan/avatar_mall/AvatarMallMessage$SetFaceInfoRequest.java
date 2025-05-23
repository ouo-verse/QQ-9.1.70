package trpc.zplan.avatar_mall;

import com.tencent.mobileqq.pb.MessageMicro;
import trpc.zplan.CsCommon$AvatarInfo;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class AvatarMallMessage$SetFaceInfoRequest extends MessageMicro<AvatarMallMessage$SetFaceInfoRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"face_info"}, new Object[]{null}, AvatarMallMessage$SetFaceInfoRequest.class);
    public CsCommon$AvatarInfo face_info = new CsCommon$AvatarInfo();
}
