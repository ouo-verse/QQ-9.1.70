package tencent.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TroopLiveSyncSvr$GetSyncGroupsRsp extends MessageMicro<TroopLiveSyncSvr$GetSyncGroupsRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<TroopLiveSyncSvr$GroupInfo> able_sync_groups = PBField.initRepeatMessage(TroopLiveSyncSvr$GroupInfo.class);
    public final PBRepeatMessageField<TroopLiveSyncSvr$GroupInfo> unable_sync_groups = PBField.initRepeatMessage(TroopLiveSyncSvr$GroupInfo.class);
    public final PBBoolField sync_switch = PBField.initBool(false);
    public final PBBoolField is_change = PBField.initBool(false);
    public final PBBoolField unable_edit = PBField.initBool(false);
    public final PBInt32Field able_sync_groups_num = PBField.initInt32(0);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 160, 168, 176, 184}, new String[]{"able_sync_groups", "unable_sync_groups", "sync_switch", "is_change", "unable_edit", "able_sync_groups_num"}, new Object[]{null, null, bool, bool, bool, 0}, TroopLiveSyncSvr$GetSyncGroupsRsp.class);
    }
}
