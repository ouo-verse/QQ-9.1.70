package ws3;

import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$$ExternalSyntheticOutline0;
import com.tencent.mm.vfs.QuotaFileSystem;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.tav.core.AssetExtension;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class bo {
    public static final Object[] a(ab abVar) {
        String a16;
        String a17;
        String a18;
        String a19;
        String a26;
        String a27;
        String a28;
        String a29;
        String a36;
        String a37;
        ArrayList arrayList = new ArrayList();
        arrayList.add("fileSetId");
        arrayList.add(abVar.f446150a);
        arrayList.add("cliFileId");
        arrayList.add(abVar.f446151b);
        arrayList.add("compressedFileFolderId");
        arrayList.add(abVar.f446152c);
        arrayList.add("archiveIndex");
        arrayList.add(ae.a(abVar.f446153d));
        arrayList.add("indexPath");
        arrayList.add(abVar.f446154e);
        arrayList.add("isDir");
        arrayList.add(Integer.valueOf(abVar.f446155f ? 1 : 0));
        arrayList.add("parentId");
        arrayList.add(abVar.f446156g);
        arrayList.add("depth");
        arrayList.add(ag.a(abVar.f446157h));
        arrayList.add("cliFileIndex");
        arrayList.add(an.a(abVar.f446158i));
        arrayList.add(TagName.FILE_TYPE);
        arrayList.add(Integer.valueOf(abVar.f446159j));
        arrayList.add("name");
        arrayList.add(abVar.f446160k);
        arrayList.add("namePinyin");
        arrayList.add(abVar.f446161l);
        arrayList.add("isCover");
        arrayList.add(Integer.valueOf(abVar.f446162m ? 1 : 0));
        arrayList.add("isCoverOriginal");
        arrayList.add(Integer.valueOf(abVar.f446163n ? 1 : 0));
        arrayList.add("fileSize");
        a16 = bc.a(abVar.f446164o, 10);
        arrayList.add(a16);
        arrayList.add(QuotaFileSystem.STAT_FILE_COUNT);
        arrayList.add(aq.a(abVar.f446165p));
        arrayList.add(AssetExtension.SCENE_THUMBNAIL);
        eg egVar = abVar.f446166q;
        ArrayList m3 = QQFlashTransferViewModel$$ExternalSyntheticOutline0.m("id");
        m3.add(egVar.f446332a);
        m3.add(CoverDBCacheData.URLS);
        m3.add(Integer.valueOf(egVar.f446333b.size()));
        for (eq eqVar : egVar.f446333b) {
            ArrayList m16 = QQFlashTransferViewModel$$ExternalSyntheticOutline0.m("spec");
            m16.add(Integer.valueOf(eqVar.f446357a));
            m16.add("url");
            m16.add(eqVar.f446358b);
            Object[] array = m16.toArray(new Object[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            m3.add(Integer.valueOf(array.length));
            CollectionsKt__MutableCollectionsKt.addAll(m3, array);
        }
        m3.add("localCachePath");
        m3.add(egVar.f446334c);
        Object[] array2 = m3.toArray(new Object[0]);
        Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        arrayList.add(Integer.valueOf(array2.length));
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, array2);
        arrayList.add("physical");
        ef efVar = abVar.f446167r;
        ArrayList m17 = QQFlashTransferViewModel$$ExternalSyntheticOutline0.m("id");
        m17.add(efVar.f446324a);
        m17.add("url");
        m17.add(efVar.f446325b);
        m17.add("status");
        m17.add(Integer.valueOf(efVar.f446326c));
        m17.add("processing");
        m17.add(efVar.f446327d);
        m17.add("localPath");
        m17.add(efVar.f446328e);
        m17.add("width");
        m17.add(ar.a(efVar.f446329f));
        m17.add("height");
        m17.add(as.a(efVar.f446330g));
        m17.add("time");
        m17.add(at.a(efVar.f446331h));
        Object[] array3 = m17.toArray(new Object[0]);
        Intrinsics.checkNotNull(array3, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        arrayList.add(Integer.valueOf(array3.length));
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, array3);
        arrayList.add("srvFileId");
        arrayList.add(abVar.f446168s);
        arrayList.add("srvParentFileId");
        arrayList.add(abVar.f446169t);
        arrayList.add("svrLastUpdateTimestamp");
        a17 = aw.a(abVar.f446170u, 10);
        arrayList.add(a17);
        arrayList.add("downloadInfo");
        ad adVar = abVar.f446171v;
        ArrayList m18 = QQFlashTransferViewModel$$ExternalSyntheticOutline0.m("status");
        m18.add(Integer.valueOf(adVar.f446179a));
        m18.add("curDownLoadedBytes");
        a18 = ay.a(adVar.f446180b, 10);
        m18.add(a18);
        m18.add("totalFileBytes");
        a19 = bg.a(adVar.f446181c, 10);
        m18.add(a19);
        m18.add("errorCode");
        m18.add(ba.a(adVar.f446182d));
        Object[] array4 = m18.toArray(new Object[0]);
        Intrinsics.checkNotNull(array4, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        arrayList.add(Integer.valueOf(array4.length));
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, array4);
        arrayList.add("saveFilePath");
        arrayList.add(abVar.f446172w);
        arrayList.add("searchRelativePath");
        arrayList.add(abVar.f446173x);
        arrayList.add("diskRelativePath");
        arrayList.add(abVar.f446174y);
        arrayList.add("uploadInfo");
        bw bwVar = abVar.f446175z;
        ArrayList m19 = QQFlashTransferViewModel$$ExternalSyntheticOutline0.m("uploadedBytes");
        a26 = az.a(bwVar.f446219a, 10);
        m19.add(a26);
        m19.add("errCode");
        m19.add(Integer.valueOf(bwVar.f446220b));
        m19.add("svrErrCode");
        m19.add(Integer.valueOf(bwVar.f446221c));
        m19.add("errMsg");
        m19.add(bwVar.f446222d);
        m19.add("isNeedDelExif");
        m19.add(Integer.valueOf(bwVar.f446223e ? 1 : 0));
        Object[] array5 = m19.toArray(new Object[0]);
        Intrinsics.checkNotNull(array5, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        arrayList.add(Integer.valueOf(array5.length));
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, array5);
        arrayList.add("status");
        arrayList.add(Integer.valueOf(abVar.A));
        arrayList.add("uploadStatus");
        arrayList.add(Integer.valueOf(abVar.B));
        arrayList.add(VirtualAppProxy.KEY_DOWNLOAD_STATUS);
        arrayList.add(Integer.valueOf(abVar.C));
        arrayList.add("folderUploadInfo");
        ce ceVar = abVar.D;
        ArrayList m26 = QQFlashTransferViewModel$$ExternalSyntheticOutline0.m("totalUploadedFileSize");
        a27 = be.a(ceVar.f446249a, 10);
        m26.add(a27);
        m26.add("successCount");
        m26.add(bj.a(ceVar.f446250b));
        m26.add("failedCount");
        m26.add(bk.a(ceVar.f446251c));
        Object[] array6 = m26.toArray(new Object[0]);
        Intrinsics.checkNotNull(array6, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        arrayList.add(Integer.valueOf(array6.length));
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, array6);
        arrayList.add("folderDownloadInfo");
        cd cdVar = abVar.E;
        ArrayList m27 = QQFlashTransferViewModel$$ExternalSyntheticOutline0.m("totalDownloadedFileSize");
        a28 = bd.a(cdVar.f446241a, 10);
        m27.add(a28);
        m27.add("totalFileSize");
        a29 = bb.a(cdVar.f446242b, 10);
        m27.add(a29);
        m27.add("totalDownloadFileCount");
        m27.add(bn.a(cdVar.f446243c));
        m27.add("successCount");
        m27.add(af.a(cdVar.f446244d));
        m27.add("failedCount");
        m27.add(ah.a(cdVar.f446245e));
        m27.add("pausedCount");
        m27.add(ai.a(cdVar.f446246f));
        m27.add("cancelCount");
        m27.add(aj.a(cdVar.f446247g));
        m27.add("downloadingCount");
        m27.add(ak.a(cdVar.f446248h));
        Object[] array7 = m27.toArray(new Object[0]);
        Intrinsics.checkNotNull(array7, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        arrayList.add(Integer.valueOf(array7.length));
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, array7);
        arrayList.add("sha1");
        arrayList.add(abVar.F);
        arrayList.add("bookmark");
        arrayList.add(abVar.G);
        arrayList.add("compressFileFolderInfo");
        k kVar = abVar.H;
        ArrayList m28 = QQFlashTransferViewModel$$ExternalSyntheticOutline0.m(VirtualAppProxy.KEY_DOWNLOAD_STATUS);
        m28.add(Integer.valueOf(kVar.f446377a));
        m28.add("saveFileDirPath");
        m28.add(kVar.f446378b);
        m28.add("totalFileCount");
        a36 = bf.a(kVar.f446379c, 10);
        m28.add(a36);
        m28.add("totalFileSize");
        a37 = ax.a(kVar.f446380d, 10);
        m28.add(a37);
        Object[] array8 = m28.toArray(new Object[0]);
        Intrinsics.checkNotNull(array8, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        arrayList.add(Integer.valueOf(array8.length));
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, array8);
        arrayList.add("uploadPauseReason");
        arrayList.add(Integer.valueOf(abVar.I));
        arrayList.add("downloadPauseReason");
        arrayList.add(Integer.valueOf(abVar.J));
        Object[] array9 = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array9, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return array9;
    }

    public static final ab b(Object[] objArr) {
        Iterator it = ArrayIteratorKt.iterator(objArr);
        ab abVar = new ab();
        while (it.hasNext()) {
            Object next = it.next();
            if (Intrinsics.areEqual(next, "fileSetId")) {
                Object next2 = it.next();
                Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.String");
                abVar.f446150a = (String) next2;
            } else if (Intrinsics.areEqual(next, "cliFileId")) {
                Object next3 = it.next();
                Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.String");
                abVar.f446151b = (String) next3;
            } else if (Intrinsics.areEqual(next, "compressedFileFolderId")) {
                Object next4 = it.next();
                Intrinsics.checkNotNull(next4, "null cannot be cast to non-null type kotlin.String");
                abVar.f446152c = (String) next4;
            } else if (Intrinsics.areEqual(next, "archiveIndex")) {
                Object next5 = it.next();
                Intrinsics.checkNotNull(next5, "null cannot be cast to non-null type kotlin.String");
                abVar.f446153d = vs3.a.a((String) next5);
            } else if (Intrinsics.areEqual(next, "indexPath")) {
                Object next6 = it.next();
                Intrinsics.checkNotNull(next6, "null cannot be cast to non-null type kotlin.String");
                abVar.f446154e = (String) next6;
            } else {
                if (Intrinsics.areEqual(next, "isDir")) {
                    Object next7 = it.next();
                    Intrinsics.checkNotNull(next7, "null cannot be cast to non-null type kotlin.Int");
                    abVar.f446155f = ((Integer) next7).intValue() == 1;
                } else if (Intrinsics.areEqual(next, "parentId")) {
                    Object next8 = it.next();
                    Intrinsics.checkNotNull(next8, "null cannot be cast to non-null type kotlin.String");
                    abVar.f446156g = (String) next8;
                } else if (Intrinsics.areEqual(next, "depth")) {
                    Object next9 = it.next();
                    Intrinsics.checkNotNull(next9, "null cannot be cast to non-null type kotlin.String");
                    abVar.f446157h = vs3.a.a((String) next9);
                } else if (Intrinsics.areEqual(next, "cliFileIndex")) {
                    Object next10 = it.next();
                    Intrinsics.checkNotNull(next10, "null cannot be cast to non-null type kotlin.String");
                    abVar.f446158i = vs3.a.a((String) next10);
                } else if (Intrinsics.areEqual(next, TagName.FILE_TYPE)) {
                    Object next11 = it.next();
                    Intrinsics.checkNotNull(next11, "null cannot be cast to non-null type kotlin.Int{ com.tencent.qq.ntkernel.flash_transfer.FlashTransferFileTypeKt.FlashTransferFileType }");
                    abVar.f446159j = ((Integer) next11).intValue();
                } else if (Intrinsics.areEqual(next, "name")) {
                    Object next12 = it.next();
                    Intrinsics.checkNotNull(next12, "null cannot be cast to non-null type kotlin.String");
                    abVar.f446160k = (String) next12;
                } else if (Intrinsics.areEqual(next, "namePinyin")) {
                    Object next13 = it.next();
                    Intrinsics.checkNotNull(next13, "null cannot be cast to non-null type kotlin.String");
                    abVar.f446161l = (String) next13;
                } else if (Intrinsics.areEqual(next, "isCover")) {
                    Object next14 = it.next();
                    Intrinsics.checkNotNull(next14, "null cannot be cast to non-null type kotlin.Int");
                    abVar.f446162m = ((Integer) next14).intValue() == 1;
                } else if (Intrinsics.areEqual(next, "isCoverOriginal")) {
                    Object next15 = it.next();
                    Intrinsics.checkNotNull(next15, "null cannot be cast to non-null type kotlin.Int");
                    abVar.f446163n = ((Integer) next15).intValue() == 1;
                } else if (Intrinsics.areEqual(next, "fileSize")) {
                    Object next16 = it.next();
                    Intrinsics.checkNotNull(next16, "null cannot be cast to non-null type kotlin.String");
                    abVar.f446164o = vs3.a.b((String) next16);
                } else if (Intrinsics.areEqual(next, QuotaFileSystem.STAT_FILE_COUNT)) {
                    Object next17 = it.next();
                    Intrinsics.checkNotNull(next17, "null cannot be cast to non-null type kotlin.String");
                    abVar.f446165p = vs3.a.a((String) next17);
                } else if (Intrinsics.areEqual(next, AssetExtension.SCENE_THUMBNAIL)) {
                    Object next18 = it.next();
                    Intrinsics.checkNotNull(next18, "null cannot be cast to non-null type kotlin.Int");
                    int intValue = ((Integer) next18).intValue();
                    Object[] objArr2 = new Object[intValue];
                    for (int i3 = 0; i3 < intValue; i3++) {
                        objArr2[i3] = it.next();
                    }
                    abVar.f446166q = eh.a(objArr2);
                } else if (Intrinsics.areEqual(next, "physical")) {
                    Object next19 = it.next();
                    Intrinsics.checkNotNull(next19, "null cannot be cast to non-null type kotlin.Int");
                    int intValue2 = ((Integer) next19).intValue();
                    Object[] objArr3 = new Object[intValue2];
                    for (int i16 = 0; i16 < intValue2; i16++) {
                        objArr3[i16] = it.next();
                    }
                    Iterator it5 = ArrayIteratorKt.iterator(objArr3);
                    ef efVar = new ef();
                    while (it5.hasNext()) {
                        Object next20 = it5.next();
                        if (Intrinsics.areEqual(next20, "id")) {
                            Object next21 = it5.next();
                            Intrinsics.checkNotNull(next21, "null cannot be cast to non-null type kotlin.String");
                            efVar.f446324a = (String) next21;
                        } else if (Intrinsics.areEqual(next20, "url")) {
                            Object next22 = it5.next();
                            Intrinsics.checkNotNull(next22, "null cannot be cast to non-null type kotlin.String");
                            efVar.f446325b = (String) next22;
                        } else if (Intrinsics.areEqual(next20, "status")) {
                            Object next23 = it5.next();
                            Intrinsics.checkNotNull(next23, "null cannot be cast to non-null type kotlin.Int{ com.tencent.qq.ntkernel.flash_transfer.ServerFileStatusKt.ServerFileStatus }");
                            efVar.f446326c = ((Integer) next23).intValue();
                        } else if (Intrinsics.areEqual(next20, "processing")) {
                            Object next24 = it5.next();
                            Intrinsics.checkNotNull(next24, "null cannot be cast to non-null type kotlin.String");
                            efVar.f446327d = (String) next24;
                        } else if (Intrinsics.areEqual(next20, "localPath")) {
                            Object next25 = it5.next();
                            Intrinsics.checkNotNull(next25, "null cannot be cast to non-null type kotlin.String");
                            efVar.f446328e = (String) next25;
                        } else if (Intrinsics.areEqual(next20, "width")) {
                            Object next26 = it5.next();
                            Intrinsics.checkNotNull(next26, "null cannot be cast to non-null type kotlin.String");
                            efVar.f446329f = vs3.a.a((String) next26);
                        } else if (Intrinsics.areEqual(next20, "height")) {
                            Object next27 = it5.next();
                            Intrinsics.checkNotNull(next27, "null cannot be cast to non-null type kotlin.String");
                            efVar.f446330g = vs3.a.a((String) next27);
                        } else if (Intrinsics.areEqual(next20, "time")) {
                            Object next28 = it5.next();
                            Intrinsics.checkNotNull(next28, "null cannot be cast to non-null type kotlin.String");
                            efVar.f446331h = vs3.a.a((String) next28);
                        }
                    }
                    abVar.f446167r = efVar;
                } else if (Intrinsics.areEqual(next, "srvFileId")) {
                    Object next29 = it.next();
                    Intrinsics.checkNotNull(next29, "null cannot be cast to non-null type kotlin.String");
                    abVar.f446168s = (String) next29;
                } else if (Intrinsics.areEqual(next, "srvParentFileId")) {
                    Object next30 = it.next();
                    Intrinsics.checkNotNull(next30, "null cannot be cast to non-null type kotlin.String");
                    abVar.f446169t = (String) next30;
                } else if (Intrinsics.areEqual(next, "svrLastUpdateTimestamp")) {
                    Object next31 = it.next();
                    Intrinsics.checkNotNull(next31, "null cannot be cast to non-null type kotlin.String");
                    abVar.f446170u = vs3.a.b((String) next31);
                } else if (Intrinsics.areEqual(next, "downloadInfo")) {
                    Object next32 = it.next();
                    Intrinsics.checkNotNull(next32, "null cannot be cast to non-null type kotlin.Int");
                    int intValue3 = ((Integer) next32).intValue();
                    Object[] objArr4 = new Object[intValue3];
                    for (int i17 = 0; i17 < intValue3; i17++) {
                        objArr4[i17] = it.next();
                    }
                    Iterator it6 = ArrayIteratorKt.iterator(objArr4);
                    ad adVar = new ad();
                    while (it6.hasNext()) {
                        Object next33 = it6.next();
                        if (Intrinsics.areEqual(next33, "status")) {
                            Object next34 = it6.next();
                            Intrinsics.checkNotNull(next34, "null cannot be cast to non-null type kotlin.Int{ com.tencent.qq.ntkernel.flash_transfer.UserActionFileDownLoadStatusKt.UserActionFileDownLoadStatus }");
                            adVar.f446179a = ((Integer) next34).intValue();
                        } else if (Intrinsics.areEqual(next33, "curDownLoadedBytes")) {
                            Object next35 = it6.next();
                            Intrinsics.checkNotNull(next35, "null cannot be cast to non-null type kotlin.String");
                            adVar.f446180b = vs3.a.b((String) next35);
                        } else if (Intrinsics.areEqual(next33, "totalFileBytes")) {
                            Object next36 = it6.next();
                            Intrinsics.checkNotNull(next36, "null cannot be cast to non-null type kotlin.String");
                            adVar.f446181c = vs3.a.b((String) next36);
                        } else if (Intrinsics.areEqual(next33, "errorCode")) {
                            Object next37 = it6.next();
                            Intrinsics.checkNotNull(next37, "null cannot be cast to non-null type kotlin.String");
                            adVar.f446182d = vs3.a.a((String) next37);
                        }
                    }
                    abVar.f446171v = adVar;
                } else if (Intrinsics.areEqual(next, "saveFilePath")) {
                    Object next38 = it.next();
                    Intrinsics.checkNotNull(next38, "null cannot be cast to non-null type kotlin.String");
                    abVar.f446172w = (String) next38;
                } else if (Intrinsics.areEqual(next, "searchRelativePath")) {
                    Object next39 = it.next();
                    Intrinsics.checkNotNull(next39, "null cannot be cast to non-null type kotlin.String");
                    abVar.f446173x = (String) next39;
                } else if (Intrinsics.areEqual(next, "diskRelativePath")) {
                    Object next40 = it.next();
                    Intrinsics.checkNotNull(next40, "null cannot be cast to non-null type kotlin.String");
                    abVar.f446174y = (String) next40;
                } else if (Intrinsics.areEqual(next, "uploadInfo")) {
                    Object next41 = it.next();
                    Intrinsics.checkNotNull(next41, "null cannot be cast to non-null type kotlin.Int");
                    int intValue4 = ((Integer) next41).intValue();
                    Object[] objArr5 = new Object[intValue4];
                    for (int i18 = 0; i18 < intValue4; i18++) {
                        objArr5[i18] = it.next();
                    }
                    Iterator it7 = ArrayIteratorKt.iterator(objArr5);
                    bw bwVar = new bw();
                    while (it7.hasNext()) {
                        Object next42 = it7.next();
                        if (Intrinsics.areEqual(next42, "uploadedBytes")) {
                            Object next43 = it7.next();
                            Intrinsics.checkNotNull(next43, "null cannot be cast to non-null type kotlin.String");
                            bwVar.f446219a = vs3.a.b((String) next43);
                        } else if (Intrinsics.areEqual(next42, "errCode")) {
                            Object next44 = it7.next();
                            Intrinsics.checkNotNull(next44, "null cannot be cast to non-null type kotlin.Int");
                            bwVar.f446220b = ((Integer) next44).intValue();
                        } else if (Intrinsics.areEqual(next42, "svrErrCode")) {
                            Object next45 = it7.next();
                            Intrinsics.checkNotNull(next45, "null cannot be cast to non-null type kotlin.Int");
                            bwVar.f446221c = ((Integer) next45).intValue();
                        } else if (Intrinsics.areEqual(next42, "errMsg")) {
                            Object next46 = it7.next();
                            Intrinsics.checkNotNull(next46, "null cannot be cast to non-null type kotlin.String");
                            bwVar.f446222d = (String) next46;
                        } else if (Intrinsics.areEqual(next42, "isNeedDelExif")) {
                            Object next47 = it7.next();
                            Intrinsics.checkNotNull(next47, "null cannot be cast to non-null type kotlin.Int");
                            bwVar.f446223e = ((Integer) next47).intValue() == 1;
                        }
                    }
                    abVar.f446175z = bwVar;
                } else if (Intrinsics.areEqual(next, "status")) {
                    Object next48 = it.next();
                    Intrinsics.checkNotNull(next48, "null cannot be cast to non-null type kotlin.Int{ com.tencent.qq.ntkernel.flash_transfer.FileStatusKt.FileStatus }");
                    abVar.A = ((Integer) next48).intValue();
                } else if (Intrinsics.areEqual(next, "uploadStatus")) {
                    Object next49 = it.next();
                    Intrinsics.checkNotNull(next49, "null cannot be cast to non-null type kotlin.Int{ com.tencent.qq.ntkernel.flash_transfer.FileUploadStatusKt.FileUploadStatus }");
                    abVar.B = ((Integer) next49).intValue();
                } else if (Intrinsics.areEqual(next, VirtualAppProxy.KEY_DOWNLOAD_STATUS)) {
                    Object next50 = it.next();
                    Intrinsics.checkNotNull(next50, "null cannot be cast to non-null type kotlin.Int{ com.tencent.qq.ntkernel.flash_transfer.FileDownloadStatusKt.FileDownloadStatus }");
                    abVar.C = ((Integer) next50).intValue();
                } else if (Intrinsics.areEqual(next, "folderUploadInfo")) {
                    Object next51 = it.next();
                    Intrinsics.checkNotNull(next51, "null cannot be cast to non-null type kotlin.Int");
                    int intValue5 = ((Integer) next51).intValue();
                    Object[] objArr6 = new Object[intValue5];
                    for (int i19 = 0; i19 < intValue5; i19++) {
                        objArr6[i19] = it.next();
                    }
                    Iterator it8 = ArrayIteratorKt.iterator(objArr6);
                    ce ceVar = new ce();
                    while (it8.hasNext()) {
                        Object next52 = it8.next();
                        if (Intrinsics.areEqual(next52, "totalUploadedFileSize")) {
                            Object next53 = it8.next();
                            Intrinsics.checkNotNull(next53, "null cannot be cast to non-null type kotlin.String");
                            ceVar.f446249a = vs3.a.b((String) next53);
                        } else if (Intrinsics.areEqual(next52, "successCount")) {
                            Object next54 = it8.next();
                            Intrinsics.checkNotNull(next54, "null cannot be cast to non-null type kotlin.String");
                            ceVar.f446250b = vs3.a.a((String) next54);
                        } else if (Intrinsics.areEqual(next52, "failedCount")) {
                            Object next55 = it8.next();
                            Intrinsics.checkNotNull(next55, "null cannot be cast to non-null type kotlin.String");
                            ceVar.f446251c = vs3.a.a((String) next55);
                        }
                    }
                    abVar.D = ceVar;
                } else if (Intrinsics.areEqual(next, "folderDownloadInfo")) {
                    Object next56 = it.next();
                    Intrinsics.checkNotNull(next56, "null cannot be cast to non-null type kotlin.Int");
                    int intValue6 = ((Integer) next56).intValue();
                    Object[] objArr7 = new Object[intValue6];
                    for (int i26 = 0; i26 < intValue6; i26++) {
                        objArr7[i26] = it.next();
                    }
                    Iterator it9 = ArrayIteratorKt.iterator(objArr7);
                    cd cdVar = new cd();
                    while (it9.hasNext()) {
                        Object next57 = it9.next();
                        if (Intrinsics.areEqual(next57, "totalDownloadedFileSize")) {
                            Object next58 = it9.next();
                            Intrinsics.checkNotNull(next58, "null cannot be cast to non-null type kotlin.String");
                            cdVar.f446241a = vs3.a.b((String) next58);
                        } else if (Intrinsics.areEqual(next57, "totalFileSize")) {
                            Object next59 = it9.next();
                            Intrinsics.checkNotNull(next59, "null cannot be cast to non-null type kotlin.String");
                            cdVar.f446242b = vs3.a.b((String) next59);
                        } else if (Intrinsics.areEqual(next57, "totalDownloadFileCount")) {
                            Object next60 = it9.next();
                            Intrinsics.checkNotNull(next60, "null cannot be cast to non-null type kotlin.String");
                            cdVar.f446243c = vs3.a.a((String) next60);
                        } else if (Intrinsics.areEqual(next57, "successCount")) {
                            Object next61 = it9.next();
                            Intrinsics.checkNotNull(next61, "null cannot be cast to non-null type kotlin.String");
                            cdVar.f446244d = vs3.a.a((String) next61);
                        } else if (Intrinsics.areEqual(next57, "failedCount")) {
                            Object next62 = it9.next();
                            Intrinsics.checkNotNull(next62, "null cannot be cast to non-null type kotlin.String");
                            cdVar.f446245e = vs3.a.a((String) next62);
                        } else if (Intrinsics.areEqual(next57, "pausedCount")) {
                            Object next63 = it9.next();
                            Intrinsics.checkNotNull(next63, "null cannot be cast to non-null type kotlin.String");
                            cdVar.f446246f = vs3.a.a((String) next63);
                        } else if (Intrinsics.areEqual(next57, "cancelCount")) {
                            Object next64 = it9.next();
                            Intrinsics.checkNotNull(next64, "null cannot be cast to non-null type kotlin.String");
                            cdVar.f446247g = vs3.a.a((String) next64);
                        } else if (Intrinsics.areEqual(next57, "downloadingCount")) {
                            Object next65 = it9.next();
                            Intrinsics.checkNotNull(next65, "null cannot be cast to non-null type kotlin.String");
                            cdVar.f446248h = vs3.a.a((String) next65);
                        }
                    }
                    abVar.E = cdVar;
                } else if (Intrinsics.areEqual(next, "sha1")) {
                    Object next66 = it.next();
                    Intrinsics.checkNotNull(next66, "null cannot be cast to non-null type kotlin.String");
                    abVar.F = (String) next66;
                } else if (Intrinsics.areEqual(next, "bookmark")) {
                    Object next67 = it.next();
                    Intrinsics.checkNotNull(next67, "null cannot be cast to non-null type kotlin.String");
                    abVar.G = (String) next67;
                } else if (Intrinsics.areEqual(next, "compressFileFolderInfo")) {
                    Object next68 = it.next();
                    Intrinsics.checkNotNull(next68, "null cannot be cast to non-null type kotlin.Int");
                    int intValue7 = ((Integer) next68).intValue();
                    Object[] objArr8 = new Object[intValue7];
                    for (int i27 = 0; i27 < intValue7; i27++) {
                        objArr8[i27] = it.next();
                    }
                    Iterator it10 = ArrayIteratorKt.iterator(objArr8);
                    k kVar = new k();
                    while (it10.hasNext()) {
                        Object next69 = it10.next();
                        if (Intrinsics.areEqual(next69, VirtualAppProxy.KEY_DOWNLOAD_STATUS)) {
                            Object next70 = it10.next();
                            Intrinsics.checkNotNull(next70, "null cannot be cast to non-null type kotlin.Int{ com.tencent.qq.ntkernel.flash_transfer.FileSetDownloadStatusKt.FileSetDownloadStatus }");
                            kVar.f446377a = ((Integer) next70).intValue();
                        } else if (Intrinsics.areEqual(next69, "saveFileDirPath")) {
                            Object next71 = it10.next();
                            Intrinsics.checkNotNull(next71, "null cannot be cast to non-null type kotlin.String");
                            kVar.f446378b = (String) next71;
                        } else if (Intrinsics.areEqual(next69, "totalFileCount")) {
                            Object next72 = it10.next();
                            Intrinsics.checkNotNull(next72, "null cannot be cast to non-null type kotlin.String");
                            kVar.f446379c = vs3.a.b((String) next72);
                        } else if (Intrinsics.areEqual(next69, "totalFileSize")) {
                            Object next73 = it10.next();
                            Intrinsics.checkNotNull(next73, "null cannot be cast to non-null type kotlin.String");
                            kVar.f446380d = vs3.a.b((String) next73);
                        }
                    }
                    abVar.H = kVar;
                } else if (Intrinsics.areEqual(next, "uploadPauseReason")) {
                    Object next74 = it.next();
                    Intrinsics.checkNotNull(next74, "null cannot be cast to non-null type kotlin.Int{ com.tencent.qq.ntkernel.flash_transfer.FlashTransferPauseReasonKt.FlashTransferPauseReason }");
                    abVar.I = ((Integer) next74).intValue();
                } else if (Intrinsics.areEqual(next, "downloadPauseReason")) {
                    Object next75 = it.next();
                    Intrinsics.checkNotNull(next75, "null cannot be cast to non-null type kotlin.Int{ com.tencent.qq.ntkernel.flash_transfer.FlashTransferPauseReasonKt.FlashTransferPauseReason }");
                    abVar.J = ((Integer) next75).intValue();
                }
            }
        }
        return abVar;
    }
}
